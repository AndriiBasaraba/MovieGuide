package basaraba.adndrii.movieguide.features.main.movie_details

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import basaraba.adndrii.movieguide.common.BaseViewModel
import basaraba.adndrii.movieguide.features.main.mapper.ShowUiMapper
import basaraba.adndrii.movieguide.features.main.model.ShowUiData
import basaraba.adndrii.movieguide.features.main.movie_details.model.MovieDetailsState
import basaraba.adndrii.movieguide.use_case.movies.DeleteShowBookmarkUseCase
import basaraba.adndrii.movieguide.use_case.movies.GetBookmarkedShowsUseCase
import basaraba.adndrii.movieguide.use_case.movies.GetMovieDetailsUseCase
import basaraba.adndrii.movieguide.use_case.movies.SaveShowBookmarkUseCase
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
    private val getMovieDetailsUseCase: GetMovieDetailsUseCase,
    private val deleteShowBookmarkUseCase: DeleteShowBookmarkUseCase,
    private val saveShowBookmarkUseCase: SaveShowBookmarkUseCase,
    private val mapper: ShowUiMapper,
    private val getBookmarkedShowsUseCase: GetBookmarkedShowsUseCase,
) : BaseViewModel<MovieDetailsUiEvent, MovieDetailsState>() {

    private val movieId: String = checkNotNull(savedStateHandle[MOVIE_ID]).toString()

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
            if (isBookmarked) saveBookmark() else deleteBookmark()

            movieDetails.update {
                it.copy(data = it.data.copy(isBookmarked = isBookmarked))
            }
        }
    }

    private fun saveBookmark() {
        viewModelScope.launch {
            saveShowBookmarkUseCase.invoke(mapper.mapToDomain(movieDetails.value.data))
        }
    }

    private fun deleteBookmark() {
        viewModelScope.launch {
            deleteShowBookmarkUseCase.invoke(movieDetails.value.data.id)
        }
    }

    init {
        getMovieDetails()
    }

    private fun getMovieDetails() {
        movieDetailsJob?.cancel()
        movieDetailsJob = viewModelScope.launch {
            movieDetails.update { it.copy(isLoading = true) }
            getMovieDetailsUseCase.invoke(movieId = movieId.toLong()).onSuccess { result ->
                movieDetails.update {
                    it.copy(
                        isLoading = false,
                        data = mapper.mapMovieDetails(result)
                    )
                }
            }
        }
        getBookmarkedStatus()
    }

    //todo is this best way for bookmark listening?
    private fun getBookmarkedStatus() {
        viewModelScope.launch {
            getBookmarkedShowsUseCase.invoke().onSuccess { bookmarksFlow ->
                bookmarksFlow.collect { list ->
                    mapper.map(list)
                        .firstOrNull { it.type == ShowUiData.Type.MOVIE && it.id == movieId.toLong() }
                        ?.let { movie ->
                            movieDetails.update { state ->
                                state.copy(
                                    data = movieDetails.value.data.copy(
                                        isBookmarked = movie.isBookmarked
                                    )
                                )
                            }
                        }
                }
            }
        }
    }

    companion object {
        private const val MOVIE_ID = "movieId"
        private const val MOVIE_TITLE = "movieTitle"
    }
}
