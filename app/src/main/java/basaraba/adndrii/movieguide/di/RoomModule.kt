package basaraba.adndrii.movieguide.di

import basaraba.adndrii.movieguide.data.db.MoviesDb
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

object RoomModule {
    val module = module {
        single { MoviesDb.getInstance(androidApplication()) }
        single { MoviesDb.getInMemoryDb(androidApplication()) }
        single { get<MoviesDb>().movieDao() }
    }
}
