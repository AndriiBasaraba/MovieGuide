package basaraba.adndrii.movieguide.data.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movie")
data class MovieEntity(
    @ColumnInfo(name = "id") val id: Long,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "overview") val overview: String,
    @ColumnInfo(name = "releaseDate") val releaseDate: String,
    @ColumnInfo(name = "poster") val poster: String,
    @ColumnInfo(name = "voteAverage") val voteAverage: Double,
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "dbId") val dbId: Long = 0
)
