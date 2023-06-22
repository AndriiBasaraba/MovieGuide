package basaraba.adndrii.movieguide.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.Room.databaseBuilder
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import basaraba.adndrii.movieguide.data.db.converters.MovieTypeConverter

@Database(
    entities = [MovieEntity::class, PersonEntity::class],
    version = 1,
    exportSchema = true
)
@TypeConverters(MovieTypeConverter::class)
abstract class MovieGuideDb : RoomDatabase() {

    abstract fun movieGuideDao(): MovieGuideDao

    companion object {
        private const val DB_NAME = "Movies.db"

        fun getDbBuilder(context: Context, dbName: String): Builder<MovieGuideDb> =
            databaseBuilder(context.applicationContext, MovieGuideDb::class.java, dbName)

        fun getInstance(context: Context): MovieGuideDb = getDbBuilder(context, DB_NAME).build()

        fun getInMemoryDbBuilder(context: Context): Builder<MovieGuideDb> =
            Room.inMemoryDatabaseBuilder(context, MovieGuideDb::class.java)

        fun getInMemoryDb(context: Context): MovieGuideDb = getInMemoryDbBuilder(context).build()
    }
}
