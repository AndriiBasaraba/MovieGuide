package basaraba.adndrii.movieguide.data.db.converters

import androidx.room.TypeConverter
import basaraba.adndrii.movieguide.data.db.MovieEntity

object MovieTypeConverter {
    @TypeConverter
    fun fromMovieType(type: MovieEntity.Type?): Int? = MovieEntity.Type.toInt(type)

    @TypeConverter
    fun fromInt(value: Int?): MovieEntity.Type? = MovieEntity.Type.fromInt(value)
}
