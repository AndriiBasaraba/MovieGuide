package basaraba.adndrii.movieguide.data.source.local

import basaraba.adndrii.movieguide.use_case.model.MovieShortData
import basaraba.adndrii.movieguide.data.db.MovieEntity

interface MoviesLocalSource {
    suspend fun getAll(): List<MovieShortData>
    suspend fun getAllByType(type: MovieEntity.Type): List<MovieShortData>
    suspend fun insertAll(movies: List<MovieShortData>)
    suspend fun delete()
    suspend fun deleteByType(type: MovieEntity.Type)
}
