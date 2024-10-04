package org.twinkle.tmdbmvvmcleanarchitecture.presentation.di.core

import dagger.Module
import dagger.Provides
import org.twinkle.tmdbmvvmcleanarchitecture.data.repository.artist.datasource.ArtistCacheDataSource
import org.twinkle.tmdbmvvmcleanarchitecture.data.repository.artist.datasourceimpl.ArtistCacheDataSourceImpl
import org.twinkle.tmdbmvvmcleanarchitecture.data.repository.movie.datasource.MovieCacheDataSource
import org.twinkle.tmdbmvvmcleanarchitecture.data.repository.movie.datasourceimpl.MovieCacheDataSourceImpl
import org.twinkle.tmdbmvvmcleanarchitecture.data.repository.tvshow.datasource.TvShowCacheDataSource
import org.twinkle.tmdbmvvmcleanarchitecture.data.repository.tvshow.datasourceimpl.TvShowCacheDataSourceImpl
import javax.inject.Singleton

@Module
class CacheDataModule {

    @Singleton
    @Provides
    fun provideMovieCacheDataSource(): MovieCacheDataSource {
        return MovieCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideArtistCacheDataSource(): ArtistCacheDataSource {
        return ArtistCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideTvShowCacheDataSource(): TvShowCacheDataSource {
        return TvShowCacheDataSourceImpl()
    }

}