package basaraba.adndrii.movieguide.di

import basaraba.adndrii.movieguide.data.db.mapper.MovieEntityMapper
import basaraba.adndrii.movieguide.data.db.mapper.MovieEntityMapperImpl
import basaraba.adndrii.movieguide.use_case.mapper.MoviesResponseMapper
import basaraba.adndrii.movieguide.use_case.mapper.MoviesResponseMapperImpl
import org.koin.dsl.module

object MapperModule {
    val module = module {
        single<MovieEntityMapper> { MovieEntityMapperImpl() }
        single<MoviesResponseMapper> { MoviesResponseMapperImpl() }
    }
}
