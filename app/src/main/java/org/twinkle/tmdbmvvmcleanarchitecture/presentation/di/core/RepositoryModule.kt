package org.twinkle.tmdbmvvmcleanarchitecture.presentation.di.core

import dagger.Module
import dagger.Provides
import org.twinkle.tmdbmvvmcleanarchitecture.data.repository.artist.ArtistRepositoryImpl
import org.twinkle.tmdbmvvmcleanarchitecture.data.repository.artist.datasource.ArtistCacheDataSource
import org.twinkle.tmdbmvvmcleanarchitecture.data.repository.artist.datasource.ArtistLocalDataSource
import org.twinkle.tmdbmvvmcleanarchitecture.data.repository.artist.datasource.ArtistRemoteDataSource
import org.twinkle.tmdbmvvmcleanarchitecture.data.repository.movie.MovieRepositoryImpl
import org.twinkle.tmdbmvvmcleanarchitecture.data.repository.movie.datasource.MovieCacheDataSource
import org.twinkle.tmdbmvvmcleanarchitecture.data.repository.movie.datasource.MovieLocalDataSource
import org.twinkle.tmdbmvvmcleanarchitecture.data.repository.movie.datasource.MovieRemoteDataSource
import org.twinkle.tmdbmvvmcleanarchitecture.data.repository.tvshow.TvShowRepositoryImpl
import org.twinkle.tmdbmvvmcleanarchitecture.data.repository.tvshow.datasource.TvShowCacheDataSource
import org.twinkle.tmdbmvvmcleanarchitecture.data.repository.tvshow.datasource.TvShowLocalDataSource
import org.twinkle.tmdbmvvmcleanarchitecture.data.repository.tvshow.datasource.TvShowRemoteDataSource
import org.twinkle.tmdbmvvmcleanarchitecture.domain.repository.ArtistRepository
import org.twinkle.tmdbmvvmcleanarchitecture.domain.repository.MovieRepository
import org.twinkle.tmdbmvvmcleanarchitecture.domain.repository.TvShowRepository
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideMovieRepository(
        movieRemoteDataSource: MovieRemoteDataSource,
        movieLocalDataSource: MovieLocalDataSource,
        movieCacheDataSource: MovieCacheDataSource
    ): MovieRepository {
        return MovieRepositoryImpl(movieRemoteDataSource, movieLocalDataSource, movieCacheDataSource)
    }

    @Singleton
    @Provides
    fun provideTvShowRepository(
        tvShowRemoteDataSource: TvShowRemoteDataSource,
        tvShowLocalDataSource: TvShowLocalDataSource,
        tvShowCacheDataSource: TvShowCacheDataSource
    ): TvShowRepository {
        return TvShowRepositoryImpl(tvShowRemoteDataSource, tvShowLocalDataSource, tvShowCacheDataSource)
    }

    @Singleton
    @Provides
    fun provideArtistRepository(
        artistRemoteDataSource: ArtistRemoteDataSource,
        artistLocalDataSource: ArtistLocalDataSource,
        artistCacheDataSource: ArtistCacheDataSource
    ): ArtistRepository {
        return ArtistRepositoryImpl(artistRemoteDataSource, artistLocalDataSource, artistCacheDataSource)
    }
}