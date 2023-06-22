package basaraba.adndrii.movieguide.data.mapper

import basaraba.adndrii.movieguide.BuildConfig
import basaraba.adndrii.movieguide.use_case.model.MovieDomainData
import basaraba.adndrii.movieguide.data.api.model.MoviesResponse

interface MoviesResponseMapper {
    fun map(response: MoviesResponse, type: MovieDomainData.Type): List<MovieDomainData>
}

class MoviesResponseMapperImpl : MoviesResponseMapper {
    override fun map(response: MoviesResponse, type: MovieDomainData.Type): List<MovieDomainData> =
        response.results.map {
            with(it) {
                MovieDomainData(
                    id = id,
                    title = title,
                    overview = overview,
                    releaseDate = releaseDate,
                    poster = BuildConfig.POSTER_URL + posterPath,
                    type = type
                )
            }
        }
}
