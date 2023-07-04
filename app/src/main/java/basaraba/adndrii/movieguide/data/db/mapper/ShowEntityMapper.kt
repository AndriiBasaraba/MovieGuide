package basaraba.adndrii.movieguide.data.db.mapper

import basaraba.adndrii.movieguide.data.db.ShowEntity
import basaraba.adndrii.movieguide.use_case.model.ShowDomainData
import javax.inject.Inject

interface ShowEntityMapper {
    fun mapToDb(show: ShowDomainData): ShowEntity
    fun mapFromDb(shows: List<ShowEntity>): List<ShowDomainData>
}

class ShowEntityMapperImpl @Inject constructor() : ShowEntityMapper {

    override fun mapToDb(show: ShowDomainData): ShowEntity =
        with(show) {
            ShowEntity(
                id = id,
                title = title,
                overview = overview,
                releaseDate = releaseDate,
                poster = poster,
                voteAverage = voteAverage,
                type = when (type) {
                    ShowDomainData.Type.MOVIE -> ShowEntity.Type.MOVIE
                    ShowDomainData.Type.TV_SHOW -> ShowEntity.Type.TV_SHOW
                    else -> null
                }
            )
        }

    override fun mapFromDb(shows: List<ShowEntity>): List<ShowDomainData> = shows.map {
        with(it) {
            ShowDomainData(
                id = id,
                title = title,
                overview = overview,
                releaseDate = releaseDate,
                poster = poster,
                voteAverage = voteAverage,
                type = when (type) {
                    ShowEntity.Type.MOVIE -> ShowDomainData.Type.MOVIE
                    ShowEntity.Type.TV_SHOW -> ShowDomainData.Type.TV_SHOW
                    else -> null
                },
                isBookmarked = true
            )
        }
    }
}
