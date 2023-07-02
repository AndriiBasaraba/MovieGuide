package basaraba.adndrii.movieguide.di

import android.content.Context
import basaraba.adndrii.movieguide.data.db.MovieGuideDb
import basaraba.adndrii.movieguide.data.db.dao.MovieDao
import basaraba.adndrii.movieguide.data.db.dao.PersonDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DatabaseModule {
    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): MovieGuideDb =
        MovieGuideDb.getInstance(appContext)

    @Provides
    fun provideMovieDao(database: MovieGuideDb): MovieDao = database.movieDao()

    @Provides
    fun providePersonDao(database: MovieGuideDb): PersonDao = database.personDao()
}
