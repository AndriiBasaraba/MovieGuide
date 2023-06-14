package basaraba.adndrii.movieguide

import android.app.Application
import basaraba.adndrii.movieguide.di.ApiModule
import basaraba.adndrii.movieguide.di.RepositoryModule
import basaraba.adndrii.movieguide.di.SourceModule
import basaraba.adndrii.movieguide.di.UseCaseModule
import basaraba.adndrii.movieguide.di.ViewModelModule
import org.koin.core.context.startKoin

class MovieApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(
                listOf(
                    ApiModule.module,
                    SourceModule.module,
                    RepositoryModule.module,
                    UseCaseModule.module,
                    ViewModelModule.module
                )
            )
        }
    }
}
