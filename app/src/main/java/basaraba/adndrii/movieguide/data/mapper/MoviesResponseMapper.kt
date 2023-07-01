package basaraba.adndrii.movieguide.data.mapper

import basaraba.adndrii.movieguide.BuildConfig
import basaraba.adndrii.movieguide.data.api.model.MoviesResponse
import basaraba.adndrii.movieguide.use_case.model.MovieDomainData
import javax.inject.Inject

interface MoviesResponseMapper {
    fun map(response: List<MoviesResponse>, type: MovieDomainData.Type): List<MovieDomainData>
}

class MoviesResponseMapperImpl @Inject constructor() : MoviesResponseMapper {
    override fun map(
        response: List<MoviesResponse>,
        type: MovieDomainData.Type
    ): List<MovieDomainData> =
        response.map {
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
