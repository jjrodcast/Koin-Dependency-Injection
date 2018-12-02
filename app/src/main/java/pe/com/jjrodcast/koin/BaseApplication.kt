package pe.com.jjrodcast.koin

import android.app.Application
import org.koin.android.ext.android.startKoin
import org.koin.dsl.module.module
import pe.com.jjrodcast.koin.model.MovieInteractor
import pe.com.jjrodcast.koin.model.MovieInteractorImp
import pe.com.jjrodcast.koin.presenter.MoviePresenter
import pe.com.jjrodcast.koin.presenter.MoviePresenterImp
import pe.com.jjrodcast.koin.view.MovieView

class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin(this, listOf(appModule))
    }

    private val appModule = module {

        single<MovieInteractor> { MovieInteractorImp() }
        factory<MoviePresenter> { (view: MovieView) -> MoviePresenterImp(view, get()) }
    }
}