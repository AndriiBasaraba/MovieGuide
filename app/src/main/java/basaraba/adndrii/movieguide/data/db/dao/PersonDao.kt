package basaraba.adndrii.movieguide.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import basaraba.adndrii.movieguide.data.db.PersonEntity

@Dao
interface PersonDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllPersons(persons: List<PersonEntity>)

    @Query("SELECT * FROM person")
    suspend fun getAllPersons(): List<PersonEntity>

    @Query("DELETE FROM person")
    suspend fun deletePersons(): Int
}
