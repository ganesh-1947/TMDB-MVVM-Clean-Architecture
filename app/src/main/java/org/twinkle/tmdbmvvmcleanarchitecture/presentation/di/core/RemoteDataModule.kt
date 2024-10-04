package org.twinkle.tmdbmvvmcleanarchitecture.presentation.di.core

import dagger.Module
import dagger.Provides
import org.twinkle.tmdbmvvmcleanarchitecture.data.api.TMDBService
import org.twinkle.tmdbmvvmcleanarchitecture.data.repository.artist.datasource.ArtistRemoteDataSource
import org.twinkle.tmdbmvvmcleanarchitecture.data.repository.artist.datasourceimpl.ArtistRemoteDataSourceImpl
import org.twinkle.tmdbmvvmcleanarchitecture.data.repository.movie.datasource.MovieRemoteDataSource
import org.twinkle.tmdbmvvmcleanarchitecture.data.repository.movie.datasourceimpl.MovieRemoteDataSourceImpl
import org.twinkle.tmdbmvvmcleanarchitecture.data.repository.tvshow.datasource.TvShowRemoteDataSource
import org.twinkle.tmdbmvvmcleanarchitecture.data.repository.tvshow.datasourceimpl.TvShowRemoteDataSourceImpl
import javax.inject.Singleton

@Module
class RemoteDataModule(private val apiKey: String) {

    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(tmdbService: TMDBService): MovieRemoteDataSource {
        return MovieRemoteDataSourceImpl(tmdbService, apiKey)
    }

    @Singleton
    @Provides
    fun provideArtistRemoteDataSource(tmdbService: TMDBService): ArtistRemoteDataSource {
        return ArtistRemoteDataSourceImpl(tmdbService, apiKey)
    }

    @Singleton
    @Provides
    fun provideTvShowRemoteDataSource(tmdbService: TMDBService): TvShowRemoteDataSource {
        return TvShowRemoteDataSourceImpl(tmdbService, apiKey)
    }

}