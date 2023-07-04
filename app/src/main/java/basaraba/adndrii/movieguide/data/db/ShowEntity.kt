package basaraba.adndrii.movieguide.data.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "show")
data class ShowEntity(
    @ColumnInfo(name = "id") val id: Long,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "overview") val overview: String,
    @ColumnInfo(name = "releaseDate") val releaseDate: String,
    @ColumnInfo(name = "poster") val poster: String,
    @ColumnInfo(name = "voteAverage") val voteAverage: Double,
    @ColumnInfo(name = "type") val type: Type?,
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "dbId") val dbId: Long = 0
) {
    enum class Type {
        MOVIE, TV_SHOW;

        companion object {
            fun fromInt(value: Int?): Type? = when (value) {
                0 -> MOVIE
                1 -> TV_SHOW
                else -> null
            }

            fun toInt(type: Type?): Int? = when (type) {
                MOVIE -> 0
                TV_SHOW -> 1
                else -> null
            }
        }
    }
}
