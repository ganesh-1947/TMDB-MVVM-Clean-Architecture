package org.twinkle.tmdbmvvmcleanarchitecture.presentation.di.core

import android.content.Context
import dagger.Module
import dagger.Provides
import org.twinkle.tmdbmvvmcleanarchitecture.presentation.di.artist.ArtistSubComponent
import org.twinkle.tmdbmvvmcleanarchitecture.presentation.di.movie.MovieSubComponent
import org.twinkle.tmdbmvvmcleanarchitecture.presentation.di.tvshow.TvShowSubComponent
import javax.inject.Singleton

@Module(subcomponents = [MovieSubComponent::class, TvShowSubComponent::class, ArtistSubComponent::class])
class AppModule(private val context: Context) {

    @Singleton
    @Provides
    fun provideApplicationContext(): Context {
        return context.applicationContext
    }

}