package basaraba.adndrii.movieguide.di

import basaraba.adndrii.movieguide.data.db.mapper.MovieEntityMapper
import basaraba.adndrii.movieguide.data.db.mapper.MovieEntityMapperImpl
import basaraba.adndrii.movieguide.data.db.mapper.PersonEntityMapper
import basaraba.adndrii.movieguide.data.db.mapper.PersonEntityMapperImpl
import basaraba.adndrii.movieguide.data.mapper.MoviesResponseMapper
import basaraba.adndrii.movieguide.data.mapper.MoviesResponseMapperImpl
import basaraba.adndrii.movieguide.data.mapper.PersonsResponseMapper
import basaraba.adndrii.movieguide.data.mapper.PersonsResponseMapperImpl
import basaraba.adndrii.movieguide.features.main.mapper.PersonUiMapper
import basaraba.adndrii.movieguide.features.main.mapper.PersonUiMapperImpl
import org.koin.dsl.module

object MapperModule {
    val module = module {
        single<MovieEntityMapper> { MovieEntityMapperImpl() }
        single<PersonEntityMapper> { PersonEntityMapperImpl() }
        single<MoviesResponseMapper> { MoviesResponseMapperImpl() }
        single<PersonsResponseMapper> { PersonsResponseMapperImpl() }
        single<PersonUiMapper> { PersonUiMapperImpl() }
    }
}
