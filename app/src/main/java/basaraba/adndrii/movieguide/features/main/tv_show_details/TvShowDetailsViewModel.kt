package basaraba.adndrii.movieguide.features.main.tv_show_details

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import basaraba.adndrii.movieguide.common.BaseViewModel
import basaraba.adndrii.movieguide.features.main.mapper.ShowUiMapper
import basaraba.adndrii.movieguide.features.main.tv_show_details.model.TvShowDetailsState
import basaraba.adndrii.movieguide.use_case.movies.DeleteShowBookmarkUseCase
import basaraba.adndrii.movieguide.use_case.movies.GetTvShowDetailsUseCase
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
class TvShowDetailsViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val getTvShowDetailsUseCase: GetTvShowDetailsUseCase,
    private val deleteShowBookmarkUseCase: DeleteShowBookmarkUseCase,
    private val saveShowBookmarkUseCase: SaveShowBookmarkUseCase,
    private val mapper: ShowUiMapper
) : BaseViewModel<TvShowDetailsUiEvent, TvShowDetailsState>() {

    private var tvShowDetailsJob: Job? = null

    private val tvShowDetails = MutableStateFlow(TvShowDetailsState())

    override val viewState: StateFlow<TvShowDetailsState> = tvShowDetails.map {
        TvShowDetailsState(
            isLoading = it.isLoading,
            tvShowTitle = checkNotNull(savedStateHandle[TV_SHOW_TITLE]).toString(),
            data = it.data
        )
    }.stateIn(viewModelScope, SharingStarted.Eagerly, TvShowDetailsState())

    override fun handleEvent(event: TvShowDetailsUiEvent) {
        if (event is TvShowDetailsUiEvent.UpdateBookmark) {
            val isBookmarked = event.isBookmarked
            if (isBookmarked) saveBookmark() else deleteBookmark()

            tvShowDetails.update {
                it.copy(data = it.data.copy(isBookmarked = isBookmarked))
            }
        }
    }

    private fun saveBookmark() {
        viewModelScope.launch {
            saveShowBookmarkUseCase.invoke(mapper.mapToDomain(tvShowDetails.value.data))
        }
    }

    private fun deleteBookmark() {
        viewModelScope.launch {
            deleteShowBookmarkUseCase.invoke(tvShowDetails.value.data.id)
        }
    }


    init {
        getTvShowDetails()
    }

    private fun getTvShowDetails() {
        tvShowDetailsJob?.cancel()
        tvShowDetailsJob = viewModelScope.launch {
            tvShowDetails.update { it.copy(isLoading = true) }
            val tvShowId: String = checkNotNull(savedStateHandle[TV_SHOW_ID]).toString()
            getTvShowDetailsUseCase.invoke(tvShowId = tvShowId.toLong()).onSuccess { result ->
                tvShowDetails.update {
                    it.copy(
                        isLoading = false,
                        data = mapper.mapTvShowDetails(result)
                    )
                }
            }
        }
    }

    companion object {
        private const val TV_SHOW_ID = "tvShowId"
        private const val TV_SHOW_TITLE = "tvShowTitle"
    }
}
