package basaraba.adndrii.movieguide.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.Room.databaseBuilder
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import basaraba.adndrii.movieguide.data.db.converters.MovieTypeConverter

@Database(
    entities = [MovieEntity::class],
    version = 1,
    exportSchema = true
)
@TypeConverters(MovieTypeConverter::class)
abstract class MoviesDb : RoomDatabase() {

    abstract fun movieDao(): MovieDao

    companion object {
        private const val DB_NAME = "Movies.db"

        fun getDbBuilder(context: Context, dbName: String): Builder<MoviesDb> =
            databaseBuilder(context.applicationContext, MoviesDb::class.java, dbName)

        fun getInstance(context: Context): MoviesDb = getDbBuilder(context, DB_NAME).build()

        fun getInMemoryDbBuilder(context: Context): Builder<MoviesDb> =
            Room.inMemoryDatabaseBuilder(context, MoviesDb::class.java)

        fun getInMemoryDb(context: Context): MoviesDb = getInMemoryDbBuilder(context).build()
    }
}
