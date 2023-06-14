package basaraba.adndrii.movieguide.di

import basaraba.adndrii.movieguide.data.db.mapper.MovieEntityMapper
import basaraba.adndrii.movieguide.data.db.mapper.MovieEntityMapperImpl
import basaraba.adndrii.movieguide.data.mapper.MoviesResponseMapper
import basaraba.adndrii.movieguide.data.mapper.MoviesResponseMapperImpl
import org.koin.dsl.module

object MapperModule {
    val module = module {
        single<MovieEntityMapper> { MovieEntityMapperImpl() }
        single<MoviesResponseMapper> { MoviesResponseMapperImpl() }
    }
}
