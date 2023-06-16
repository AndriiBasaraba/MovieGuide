package basaraba.adndrii.movieguide.data.db.mapper

import basaraba.adndrii.movieguide.use_case.model.MovieShortData
import basaraba.adndrii.movieguide.data.db.MovieEntity

interface MovieEntityMapper {
    fun mapToDb(movies: List<MovieShortData>): List<MovieEntity>
    fun mapFromDb(movies: List<MovieEntity>): List<MovieShortData>
}

class MovieEntityMapperImpl : MovieEntityMapper {

    override fun mapToDb(movies: List<MovieShortData>): List<MovieEntity> = movies.map {
        with(it) {
            MovieEntity(
                id = id,
                title = title,
                overview = overview,
                releaseDate = releaseDate,
                poster = poster,
                type = when (type) {
                    MovieShortData.Type.Ongoing -> MovieEntity.Type.Ongoing
                    MovieShortData.Type.Upcoming -> MovieEntity.Type.Upcoming
                    else -> null
                }
            )
        }
    }


    override fun mapFromDb(movies: List<MovieEntity>): List<MovieShortData> = movies.map {
        with(it) {
            MovieShortData(
                id = id,
                title = title,
                overview = overview,
                releaseDate = releaseDate,
                poster = poster,
                type = when (type) {
                    MovieEntity.Type.Ongoing -> MovieShortData.Type.Ongoing
                    MovieEntity.Type.Upcoming -> MovieShortData.Type.Upcoming
                    else -> null
                }
            )
        }
    }
}
