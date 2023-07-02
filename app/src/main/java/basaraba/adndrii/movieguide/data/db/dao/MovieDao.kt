package basaraba.adndrii.movieguide.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import basaraba.adndrii.movieguide.data.db.MovieEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllMovies(movies: List<MovieEntity>)

    @Query("SELECT * FROM movie")
    fun getAllMovies(): Flow<List<MovieEntity>>

    @Query("DELETE FROM movie")
    suspend fun deleteMovies(): Int

    @Query("SELECT EXISTS(SELECT * FROM movie WHERE id = :movieId)")
    suspend fun isMovieBookmarked(movieId: Int): Boolean
}
