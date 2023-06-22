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
    @ColumnInfo(name = "type") val type: Type?,
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "dbId") val dbId: Long = 0
) {
    enum class Type {
        Ongoing, Upcoming;

        companion object {
            fun fromInt(value: Int?): Type? = when (value) {
                0 -> Ongoing
                1 -> Upcoming
                else -> null
            }

            fun toInt(type: Type?): Int? = when (type) {
                Ongoing -> 0
                Upcoming -> 1
                else -> null
            }
        }
    }
}
