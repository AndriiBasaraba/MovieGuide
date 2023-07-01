package basaraba.adndrii.movieguide.data.source.local.movies

import basaraba.adndrii.movieguide.use_case.model.MovieDomainData

interface MoviesLocalSource {
    suspend fun getAll(): List<MovieDomainData>
    suspend fun insertAll(movies: List<MovieDomainData>)
    suspend fun delete()
}
