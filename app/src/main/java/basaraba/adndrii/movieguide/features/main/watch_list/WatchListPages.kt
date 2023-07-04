package basaraba.adndrii.movieguide.features.main.watch_list

import androidx.annotation.StringRes
import basaraba.adndrii.movieguide.R

enum class WatchListPages(@StringRes val title: Int) {
    MOVIES(R.string.movies),
    TV_SHOWS(R.string.tv_shows)
}
