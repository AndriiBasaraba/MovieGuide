package basaraba.adndrii.movieguide.data.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "person")
data class PersonEntity(
    @ColumnInfo(name = "id") val id: Long,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "avatar") val avatar: String,
    @ColumnInfo(name = "department") val department: String,
    @ColumnInfo(name = "popularity") val popularity: Double,
    @ColumnInfo(name = "knownFor") val knownFor: String,
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "dbId") val dbId: Long = 0
)
