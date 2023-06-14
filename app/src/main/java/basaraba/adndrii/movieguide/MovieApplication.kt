package basaraba.adndrii.movieguide

import android.app.Application
import basaraba.adndrii.movieguide.di.DependenciesModules
import org.koin.core.context.startKoin

class MovieApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(
                listOf(
                    DependenciesModules.apiModule,
                    DependenciesModules.sourceModule,
                    DependenciesModules.repositoriesModule,
                    DependenciesModules.useCasesModule,
                    DependenciesModules.viewModelModule
                )
            )
        }
    }
}
