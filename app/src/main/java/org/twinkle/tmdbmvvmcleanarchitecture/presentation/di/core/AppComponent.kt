package org.twinkle.tmdbmvvmcleanarchitecture.presentation.di.core

import dagger.Component
import org.twinkle.tmdbmvvmcleanarchitecture.presentation.di.artist.ArtistSubComponent
import org.twinkle.tmdbmvvmcleanarchitecture.presentation.di.movie.MovieSubComponent
import org.twinkle.tmdbmvvmcleanarchitecture.presentation.di.tvshow.TvShowSubComponent
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        NetModule::class,
        DataBaseModule::class,
        UseCaseModule::class,
        RepositoryModule::class,
        RemoteDataModule::class,
        LocalDataModule::class,
        CacheDataModule::class
    ]
)
interface AppComponent {

    fun movieSubComponent():MovieSubComponent.Factory
    fun tvShowSubComponent():TvShowSubComponent.Factory
    fun artistSubComponent():ArtistSubComponent.Factory

}