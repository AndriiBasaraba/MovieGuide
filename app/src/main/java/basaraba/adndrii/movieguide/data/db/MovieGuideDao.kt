package basaraba.adndrii.movieguide.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface MovieGuideDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllMovies(movies: List<MovieEntity>)

    @Query("SELECT * FROM movie")
    suspend fun getAllMovies(): List<MovieEntity>

    @Query("SELECT * FROM movie WHERE movie.type is :type")
    suspend fun getAllMoviesByType(type: MovieEntity.Type): List<MovieEntity>

    @Query("DELETE FROM movie")
    suspend fun deleteMovies(): Int

    @Query("DELETE FROM movie WHERE movie.type is :type")
    suspend fun deleteMoviesByType(type: MovieEntity.Type): Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllPersons(persons: List<PersonEntity>)

    @Query("SELECT * FROM person")
    suspend fun getAllPersons(): List<PersonEntity>

    @Query("DELETE FROM person")
    suspend fun deletePersons(): Int
}