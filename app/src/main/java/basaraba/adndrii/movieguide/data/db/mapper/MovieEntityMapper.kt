package basaraba.adndrii.movieguide.data.db.mapper

import basaraba.adndrii.movieguide.use_case.model.MovieDomainData
import basaraba.adndrii.movieguide.data.db.MovieEntity
import javax.inject.Inject

interface MovieEntityMapper {
    fun mapToDb(movies: List<MovieDomainData>): List<MovieEntity>
    fun mapFromDb(movies: List<MovieEntity>): List<MovieDomainData>
}

class MovieEntityMapperImpl @Inject constructor()  : MovieEntityMapper {

    override fun mapToDb(movies: List<MovieDomainData>): List<MovieEntity> = movies.map {
        with(it) {
            MovieEntity(
                id = id,
                title = title,
                overview = overview,
                releaseDate = releaseDate,
                poster = poster,
                type = when (type) {
                    MovieDomainData.Type.Ongoing -> MovieEntity.Type.Ongoing
                    MovieDomainData.Type.Upcoming -> MovieEntity.Type.Upcoming
                    else -> null
                }
            )
        }
    }


    override fun mapFromDb(movies: List<MovieEntity>): List<MovieDomainData> = movies.map {
        with(it) {
            MovieDomainData(
                id = id,
                title = title,
                overview = overview,
                releaseDate = releaseDate,
                poster = poster,
                type = when (type) {
                    MovieEntity.Type.Ongoing -> MovieDomainData.Type.Ongoing
                    MovieEntity.Type.Upcoming -> MovieDomainData.Type.Upcoming
                    else -> null
                }
            )
        }
    }
}
