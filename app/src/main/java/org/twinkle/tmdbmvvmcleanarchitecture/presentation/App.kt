package org.twinkle.tmdbmvvmcleanarchitecture.presentation

import android.app.Application
import org.twinkle.tmdbmvvmcleanarchitecture.BuildConfig
import org.twinkle.tmdbmvvmcleanarchitecture.presentation.di.Injector
import org.twinkle.tmdbmvvmcleanarchitecture.presentation.di.artist.ArtistSubComponent
import org.twinkle.tmdbmvvmcleanarchitecture.presentation.di.core.AppComponent
import org.twinkle.tmdbmvvmcleanarchitecture.presentation.di.core.AppModule
import org.twinkle.tmdbmvvmcleanarchitecture.presentation.di.core.NetModule
import org.twinkle.tmdbmvvmcleanarchitecture.presentation.di.core.RemoteDataModule
import org.twinkle.tmdbmvvmcleanarchitecture.presentation.di.movie.MovieSubComponent
import org.twinkle.tmdbmvvmcleanarchitecture.presentation.di.tvshow.TvShowSubComponent

class App: Application(), Injector {

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        /*appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule(BuildConfig.BASE_URL))
            .remoteDataModule(RemoteDataModule(BuildConfig.API_KEY))
            .build()*/
    }

    override fun createMovieSubComponent(): MovieSubComponent {
        return appComponent.movieSubComponent().create()
    }

    override fun createTvShowSubComponent(): TvShowSubComponent {
        return appComponent.tvShowSubComponent().create()
    }

    override fun createArtistSubComponent(): ArtistSubComponent {
        return appComponent.artistSubComponent().create()
    }
}