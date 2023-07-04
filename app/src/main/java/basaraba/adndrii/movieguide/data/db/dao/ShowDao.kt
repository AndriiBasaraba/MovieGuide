package basaraba.adndrii.movieguide.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import basaraba.adndrii.movieguide.data.db.ShowEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ShowDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertShow(movie: ShowEntity)

    @Query("SELECT * FROM show")
    fun getAllShows(): Flow<List<ShowEntity>>

    @Query("DELETE FROM show")
    suspend fun deleteShows()

    @Query("DELETE FROM show WHERE id = :showId")
    suspend fun deleteShow(showId: Long)

    @Query("SELECT EXISTS(SELECT * FROM show WHERE id = :showId)")
    suspend fun isShowBookmarked(showId: Long): Boolean
}
