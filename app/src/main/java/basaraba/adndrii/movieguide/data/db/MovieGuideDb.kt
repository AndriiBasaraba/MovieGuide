package basaraba.adndrii.movieguide.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.Room.databaseBuilder
import androidx.room.RoomDatabase
import basaraba.adndrii.movieguide.data.db.dao.MovieDao
import basaraba.adndrii.movieguide.data.db.dao.PersonDao

@Database(
    entities = [MovieEntity::class, PersonEntity::class],
    version = 1,
    exportSchema = true
)

abstract class MovieGuideDb : RoomDatabase() {

    abstract fun movieDao(): MovieDao
    
    abstract fun personDao(): PersonDao

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
