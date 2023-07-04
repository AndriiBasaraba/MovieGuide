package basaraba.adndrii.movieguide.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.Room.databaseBuilder
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import basaraba.adndrii.movieguide.data.db.converter.ShowTypeConverter
import basaraba.adndrii.movieguide.data.db.dao.PersonDao
import basaraba.adndrii.movieguide.data.db.dao.ShowDao

@Database(
    entities = [ShowEntity::class, PersonEntity::class],
    version = 2,
    exportSchema = true
)
@TypeConverters(ShowTypeConverter::class)
abstract class MovieGuideDb : RoomDatabase() {

    abstract fun showDao(): ShowDao

    abstract fun personDao(): PersonDao

    companion object {
        private const val DB_NAME = "Movies.db"

        fun getDbBuilder(context: Context, dbName: String): Builder<MovieGuideDb> =
            databaseBuilder(context.applicationContext, MovieGuideDb::class.java, dbName)
                .fallbackToDestructiveMigration()
                .addMigrations(MIGRATION_1_2)

        fun getInstance(context: Context): MovieGuideDb = getDbBuilder(context, DB_NAME).build()

        fun getInMemoryDbBuilder(context: Context): Builder<MovieGuideDb> =
            Room.inMemoryDatabaseBuilder(context, MovieGuideDb::class.java)

        fun getInMemoryDb(context: Context): MovieGuideDb = getInMemoryDbBuilder(context).build()


        private val MIGRATION_1_2 = object : Migration(1, 2) {

            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE movie RENAME TO show")
                database.execSQL("ALTER TABLE show ADD COLUMN type INT NULL DEFAULT NULL")
            }
        }
    }
}
