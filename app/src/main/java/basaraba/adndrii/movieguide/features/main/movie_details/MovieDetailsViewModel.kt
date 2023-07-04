package basaraba.adndrii.movieguide.features.main.movie_details

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import basaraba.adndrii.movieguide.common.BaseViewModel
import basaraba.adndrii.movieguide.features.main.mapper.ShowUiMapper
import basaraba.adndrii.movieguide.features.main.movie_details.model.MovieDetailsState
import basaraba.adndrii.movieguide.use_case.movies.DeleteMovieBookmarkUseCase
import basaraba.adndrii.movieguide.use_case.movies.GetMovieDetailUseCase
import basaraba.adndrii.movieguide.use_case.movies.SaveMovieBookmarkUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailsViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val getMovieDetailUseCase: GetMovieDetailUseCase,
    private val deleteMovieBookmarkUseCase: DeleteMovieBookmarkUseCase,
    private val saveMovieBookmarkUseCase: SaveMovieBookmarkUseCase,
    private val mapper: ShowUiMapper
) : BaseViewModel<MovieDetailsUiEvent, MovieDetailsState>() {

    private var movieDetailsJob: Job? = null

    private val movieDetails = MutableStateFlow(MovieDetailsState())

    override val viewState: StateFlow<MovieDetailsState> = movieDetails.map {
        MovieDetailsState(
            isLoading = it.isLoading,
            movieTitle = checkNotNull(savedStateHandle[MOVIE_TITLE]).toString(),
            data = it.data
        )
    }.stateIn(viewModelScope, SharingStarted.Eagerly, MovieDetailsState())

    override fun handleEvent(event: MovieDetailsUiEvent) {
        if (event is MovieDetailsUiEvent.UpdateBookmark) {
            val isBookmarked = event.isBookmarked
            if (isBookmarked) saveMovieBookmark() else deleteMovieBookmark()

            movieDetails.update {
                it.copy(data = it.data.copy(isBookmarked = isBookmarked))
            }
        }
    }

    private fun saveMovieBookmark() {
        viewModelScope.launch {
            saveMovieBookmarkUseCase.invoke(mapper.mapToDomain(movieDetails.value.data))
        }
    }

    private fun deleteMovieBookmark() {
        viewModelScope.launch {
            deleteMovieBookmarkUseCase.invoke(movieDetails.value.data.id)
        }
    }

    init {
        getMovieDetail()
    }

    private fun getMovieDetail() {
        movieDetailsJob?.cancel()
        movieDetailsJob = viewModelScope.launch {
            movieDetails.update { it.copy(isLoading = true) }
            val movieId: String = checkNotNull(savedStateHandle[MOVIE_ID]).toString()
            getMovieDetailUseCase.invoke(movieId = movieId.toLong()).onSuccess { result ->
                movieDetails.update {
                    it.copy(
                        isLoading = false,
                        data = mapper.mapMovieDetails(result)
                    )
                }
            }
        }
    }

    companion object {
        private const val MOVIE_ID = "movieId"
        private const val MOVIE_TITLE = "movieTitle"
    }
}
