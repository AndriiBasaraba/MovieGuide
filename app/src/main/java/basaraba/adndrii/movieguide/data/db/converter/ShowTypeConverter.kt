package basaraba.adndrii.movieguide.data.db.converter

import androidx.room.TypeConverter
import basaraba.adndrii.movieguide.data.db.ShowEntity

object ShowTypeConverter {
    @TypeConverter
    fun fromShowType(type: ShowEntity.Type?): Int? = ShowEntity.Type.toInt(type)

    @TypeConverter
    fun fromInt(value: Int?): ShowEntity.Type? = ShowEntity.Type.fromInt(value)
}
