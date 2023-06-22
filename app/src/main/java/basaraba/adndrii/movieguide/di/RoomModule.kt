package basaraba.adndrii.movieguide.di

import basaraba.adndrii.movieguide.data.db.MovieGuideDb
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

object RoomModule {
    val module = module {
        single { MovieGuideDb.getInstance(androidApplication()) }
        single { get<MovieGuideDb>().movieGuideDao() }
    }
}
