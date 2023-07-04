package basaraba.adndrii.movieguide.features.main.watch_list

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import basaraba.adndrii.movieguide.R
import basaraba.adndrii.movieguide.features.main.model.ShowUiData
import basaraba.adndrii.movieguide.features.main.watch_list.model.WatchListState
import basaraba.adndrii.movieguide.features.ui_components.ProgressBar
import basaraba.adndrii.movieguide.features.ui_components.RatingCircle
import basaraba.adndrii.movieguide.features.ui_components.SearchShowBar
import coil.compose.AsyncImage
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.pagerTabIndicatorOffset
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class, ExperimentalPagerApi::class)
@Composable
fun WatchListScreenUi(
    onEvent: (WatchListUiEvent) -> Unit,
    viewState: WatchListState
) {
    val pages = listOf(WatchListPages.MOVIES, WatchListPages.TV_SHOWS)
    val pagerState = rememberPagerState {
        pages.size
    }
    val coroutineScope = rememberCoroutineScope()
    val tabIndex = pagerState.currentPage

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            SearchShowBar(
                query = viewState.searchQuery,
                onQueryChange = { text -> onEvent(WatchListUiEvent.OnQueryChange(text)) }
            )
        }
    ) {
        Column(modifier = Modifier.padding(it)) {
            TabRow(
                selectedTabIndex = tabIndex,
                indicator = { tabPositions ->
                    TabRowDefaults.SecondaryIndicator(
                        modifier = Modifier.pagerTabIndicatorOffset(pagerState, tabPositions),
                        height = 2.dp,
                        color = MaterialTheme.colorScheme.inverseSurface
                    )
                },
                modifier = Modifier.height(56.dp),
                backgroundColor = MaterialTheme.colorScheme.background,
                contentColor = MaterialTheme.colorScheme.background
            ) {
                pages.forEachIndexed { index, page ->
                    Tab(
                        selected = tabIndex == index,
                        onClick = {
                            coroutineScope.launch {
                                pagerState.animateScrollToPage(index)
                            }
                        },
                        text = {
                            Text(
                                text = stringResource(id = page.title),
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Medium
                            )
                        }
                    )
                }
            }

            HorizontalPager(
                state = pagerState,
                userScrollEnabled = false
            ) { pageIndex ->
                when (pages[pageIndex]) {
                    WatchListPages.MOVIES -> WatchListShow(
                        onEvent = onEvent,
                        viewState = viewState
                    )

                    WatchListPages.TV_SHOWS -> WatchListTvShows(
                        onEvent = onEvent,
                        viewState = viewState
                    )
                }
            }
        }
    }
}

@Composable
private fun WatchListShow(
    onEvent: (WatchListUiEvent) -> Unit,
    viewState: WatchListState
) {
    if (viewState.isLoading) {
        ProgressBar()
    } else {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 16.dp)
        ) {
            items(viewState.movies) { movie ->
                WatchListMovieCard(
                    show = movie,
                    onCardClick = { movieId, title ->
                        onEvent(WatchListUiEvent.OpenMovieDetails(movieId, title))
                    },
                    onBookmarkClick = { movieId ->
                        onEvent(WatchListUiEvent.DeleteBookmark(movieId))
                    }
                )
            }
        }
    }
}

@Composable
private fun WatchListMovieCard(
    show: ShowUiData,
    onCardClick: (Long, String) -> Unit,
    onBookmarkClick: (Long) -> Unit
) {
    Box {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .clickable { onCardClick.invoke(show.id, show.title) },
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
            elevation = CardDefaults.elevatedCardElevation(defaultElevation = 4.dp)
        ) {
            Row {
                AsyncImage(
                    model = show.poster,
                    contentDescription = null,
                    modifier = Modifier
                        .height(200.dp)
                        .width(120.dp)
                        .clip(shape = RoundedCornerShape(12.dp)),
                    contentScale = ContentScale.Crop,
                    placeholder = painterResource(id = R.drawable.ic_image_placeholder),
                    error = painterResource(id = R.drawable.ic_image_placeholder)
                )
                Column(
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                ) {
                    Text(
                        modifier = Modifier.padding(start = 8.dp, end = 16.dp, top = 2.dp),
                        text = show.title,
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.SemiBold,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    Text(
                        modifier = Modifier.padding(start = 8.dp, top = 8.dp, end = 16.dp),
                        text = show.releaseDate,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Medium,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    Text(
                        modifier = Modifier.padding(start = 8.dp, top = 8.dp, end = 16.dp),
                        text = show.overview,
                        style = MaterialTheme.typography.titleSmall,
                        fontWeight = FontWeight.Normal,
                        maxLines = 4,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }
        }

        RatingCircle(
            rating = show.voteAverage,
            textSize = 12.sp,
            strokeWidth = 2.dp,
            modifier = Modifier
                .padding(start = 90.dp)
                .size(40.dp)
                .align(Alignment.BottomStart)
        )

        Image(
            painter = painterResource(R.drawable.ic_filled_bookmarked),
            contentDescription = null,
            colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.inverseSurface),
            modifier = Modifier
                .padding(top = 4.dp, end = 8.dp)
                .align(Alignment.TopEnd)
                .clickable { onBookmarkClick.invoke(show.id) }
        )
    }
}

@Composable
private fun WatchListTvShows(
    onEvent: (WatchListUiEvent) -> Unit,
    viewState: WatchListState
) {
    if (viewState.isLoading) {
        ProgressBar()
    } else {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 16.dp)
        ) {
            items(viewState.tvShows) { tvShow ->
                WatchListMovieCard(
                    show = tvShow,
                    onCardClick = { tvShowId, title ->
                        onEvent(WatchListUiEvent.OpenTvShowDetails(tvShowId, title))
                    },
                    onBookmarkClick = { tvShowId ->
                        onEvent(WatchListUiEvent.DeleteBookmark(tvShowId))
                    }
                )
            }
        }
    }

}
