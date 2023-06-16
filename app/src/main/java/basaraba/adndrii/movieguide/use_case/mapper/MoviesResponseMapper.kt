package basaraba.adndrii.movieguide.use_case.mapper

import basaraba.adndrii.movieguide.use_case.model.MovieShortData
import basaraba.adndrii.movieguide.data.api.model.MoviesResponse

interface MoviesResponseMapper {
    fun map(response: MoviesResponse, type: MovieShortData.Type): List<MovieShortData>
}

class MoviesResponseMapperImpl : MoviesResponseMapper {
    override fun map(response: MoviesResponse, type: MovieShortData.Type): List<MovieShortData> =
        response.results.map {
            with(it) {
                MovieShortData(
                    id = id,
                    title = title,
                    overview = overview,
                    releaseDate = releaseDate,
                    poster = POSTER_URL + posterPath,
                    type = type
                )
            }
        }

    companion object {
        private const val POSTER_URL = "https://image.tmdb.org/t/p/w300"
    }
}
