package org.twinkle.tmdbmvvmcleanarchitecture.presentation.di.core

import dagger.Module
import dagger.Provides
import org.twinkle.tmdbmvvmcleanarchitecture.data.database.ArtistDAO
import org.twinkle.tmdbmvvmcleanarchitecture.data.database.MovieDAO
import org.twinkle.tmdbmvvmcleanarchitecture.data.database.TvShowDAO
import org.twinkle.tmdbmvvmcleanarchitecture.data.repository.artist.datasource.ArtistLocalDataSource
import org.twinkle.tmdbmvvmcleanarchitecture.data.repository.artist.datasourceimpl.ArtistLocalDataSourceImpl
import org.twinkle.tmdbmvvmcleanarchitecture.data.repository.movie.datasource.MovieLocalDataSource
import org.twinkle.tmdbmvvmcleanarchitecture.data.repository.movie.datasourceimpl.MovieLocalDataSourceImpl
import org.twinkle.tmdbmvvmcleanarchitecture.data.repository.tvshow.datasource.TvShowLocalDataSource
import org.twinkle.tmdbmvvmcleanarchitecture.data.repository.tvshow.datasourceimpl.TvShowLocalDataSourceImpl
import javax.inject.Singleton

@Module
class LocalDataModule {

    @Singleton
    @Provides
    fun provideMovieLocalDataSource(movieDao: MovieDAO): MovieLocalDataSource {
        return MovieLocalDataSourceImpl(movieDao)
    }


    @Singleton
    @Provides
    fun provideArtistLocalDataSource(artistDAO: ArtistDAO): ArtistLocalDataSource {
        return ArtistLocalDataSourceImpl(artistDAO)
    }

    @Singleton
    @Provides
    fun provideTvShowLocalDataSource(tvShowDAO: TvShowDAO): TvShowLocalDataSource {
        return TvShowLocalDataSourceImpl(tvShowDAO)
    }

}