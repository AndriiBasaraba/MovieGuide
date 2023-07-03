package basaraba.adndrii.movieguide.features.main.mapper

import basaraba.adndrii.movieguide.features.main.movie_details.model.MovieCast
import basaraba.adndrii.movieguide.features.main.movie_details.model.MovieCollection
import basaraba.adndrii.movieguide.features.main.movie_details.model.MovieDetailsUiData
import basaraba.adndrii.movieguide.features.main.movie_details.model.MovieGenre
import basaraba.adndrii.movieguide.features.main.movie_details.model.MovieKeyword
import basaraba.adndrii.movieguide.features.main.model.MovieUiData
import basaraba.adndrii.movieguide.use_case.model.MovieCastDomain
import basaraba.adndrii.movieguide.use_case.model.MovieCollectionDomain
import basaraba.adndrii.movieguide.use_case.model.MovieDetailsDomainData
import basaraba.adndrii.movieguide.use_case.model.MovieDomainData
import javax.inject.Inject

interface MovieUiMapper {
    fun map(input: List<MovieDomainData>): List<MovieUiData>
    fun mapMovieDetails(input: MovieDetailsDomainData): MovieDetailsUiData
    fun mapToDomain(input: MovieDetailsUiData): MovieDomainData
}

class MovieUiMapperImpl @Inject constructor() : MovieUiMapper {
    override fun map(input: List<MovieDomainData>): List<MovieUiData> =
        input.map {
            with(it) {
                MovieUiData(
                    id = id,
                    title = title,
                    overview = overview,
                    releaseDate = releaseDate,
                    poster = poster,
                    isBookmarked = isBookmarked
                )
            }
        }

    override fun mapMovieDetails(input: MovieDetailsDomainData): MovieDetailsUiData =
        with(input) {
            MovieDetailsUiData(
                id = id,
                title = title,
                imdbId = imdbId,
                overview = overview,
                budget = budget,
                revenue = revenue,
                poster = poster,
                releaseDate = releaseDate,
                runTime = runTime,
                tagLine = tagLine,
                voteAverage = voteAverage,
                voteCount = voteCount,
                status = status,
                isBookmarked = isBookmarked,
                images = images,
                movieCollection = mapCollection(movieCollection),
                genres = genres.map { genre -> MovieGenre(genre.id, genre.name) },
                recommendations = map(recommendations),
                keywords = keywords.map { keyword -> MovieKeyword(keyword.id, keyword.name) },
                movieCredits = movieCredits.map { credit -> mapMovieCredits(credit) }
            )
        }

    private fun mapCollection(input: MovieCollectionDomain?): MovieCollection? =
        if (input == null) null else MovieCollection(
            id = input.id,
            name = input.name,
            poster = input.posterPath
        )

    private fun mapMovieCredits(input: MovieCastDomain): MovieCast =
        with(input) {
            MovieCast(
                id = id,
                name = name,
                popularity = popularity,
                avatar = avatar,
                role = role
            )
        }

    override fun mapToDomain(input: MovieDetailsUiData): MovieDomainData =
        with(input) {
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
