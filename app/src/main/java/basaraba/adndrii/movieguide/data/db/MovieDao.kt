package basaraba.adndrii.movieguide.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(movies: List<MovieEntity>)

    @Query("SELECT * FROM movie")
    suspend fun getAll(): List<MovieEntity>

    @Query("SELECT * FROM movie WHERE movie.type IN (:type)")
    suspend fun getAllByType(type: MovieEntity.Type): List<MovieEntity>

    @Query("DELETE FROM movie")
    suspend fun delete(): Int
}
