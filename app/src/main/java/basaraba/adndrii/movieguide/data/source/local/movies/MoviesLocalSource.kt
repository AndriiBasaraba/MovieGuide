package basaraba.adndrii.movieguide.data.source.local.movies

import basaraba.adndrii.movieguide.use_case.model.MovieDomainData
import basaraba.adndrii.movieguide.data.db.MovieEntity

interface MoviesLocalSource {
    suspend fun getAll(): List<MovieDomainData>
    suspend fun getAllByType(type: MovieEntity.Type): List<MovieDomainData>
    suspend fun insertAll(movies: List<MovieDomainData>)
    suspend fun delete()
    suspend fun deleteByType(type: MovieEntity.Type)
}
