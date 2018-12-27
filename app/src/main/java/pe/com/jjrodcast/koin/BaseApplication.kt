package pe.com.jjrodcast.koin

import android.app.Application
import org.koin.android.ext.android.startKoin
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module
import pe.com.jjrodcast.koin.model.MovieRepository
import pe.com.jjrodcast.koin.model.MovieRepositoryImp
import pe.com.jjrodcast.koin.viewmodel.MovieViewModel

class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin(this, listOf(appModule))
    }

    private val appModule = module {

        single<MovieRepository> { MovieRepositoryImp() }

        viewModel { MovieViewModel(get()) }
    }
}