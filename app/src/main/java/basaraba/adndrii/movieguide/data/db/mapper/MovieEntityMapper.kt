package basaraba.adndrii.movieguide.data.db.mapper

import basaraba.adndrii.movieguide.data.db.MovieEntity
import basaraba.adndrii.movieguide.use_case.model.MovieDomainData
import javax.inject.Inject

interface MovieEntityMapper {
    fun mapToDb(movies: List<MovieDomainData>): List<MovieEntity>
    fun mapToDb(movie: MovieDomainData): MovieEntity
    fun mapFromDb(movies: List<MovieEntity>): List<MovieDomainData>
}

class MovieEntityMapperImpl @Inject constructor() : MovieEntityMapper {

    override fun mapToDb(movie: MovieDomainData): MovieEntity =
        with(movie) {
            MovieEntity(
                id = id,
                title = title,
                overview = overview,
                releaseDate = releaseDate,
                poster = poster
            )
        }

    override fun mapToDb(movies: List<MovieDomainData>): List<MovieEntity> =
        movies.map { mapToDb(it) }

    override fun mapFromDb(movies: List<MovieEntity>): List<MovieDomainData> = movies.map {
        with(it) {
            MovieDomainData(
                id = id,
                title = title,
                overview = overview,
                releaseDate = releaseDate,
                poster = poster,
                isBookmarked = true
            )
        }
    }
}
