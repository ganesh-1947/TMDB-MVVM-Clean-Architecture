package org.twinkle.tmdbmvvmcleanarchitecture.presentation.di.core

import dagger.Module
import dagger.Provides
import org.twinkle.tmdbmvvmcleanarchitecture.domain.repository.ArtistRepository
import org.twinkle.tmdbmvvmcleanarchitecture.domain.repository.MovieRepository
import org.twinkle.tmdbmvvmcleanarchitecture.domain.repository.TvShowRepository
import org.twinkle.tmdbmvvmcleanarchitecture.domain.usecase.GetArtistsUseCase
import org.twinkle.tmdbmvvmcleanarchitecture.domain.usecase.GetMoviesUseCase
import org.twinkle.tmdbmvvmcleanarchitecture.domain.usecase.GetTvShowsUseCase
import org.twinkle.tmdbmvvmcleanarchitecture.domain.usecase.UpdateArtistsUseCase
import org.twinkle.tmdbmvvmcleanarchitecture.domain.usecase.UpdateMoviesUsecase
import org.twinkle.tmdbmvvmcleanarchitecture.domain.usecase.UpdateTvShowsUseCase

@Module
class UseCaseModule {

    @Provides
    fun provideGetMovieUseCase(movieRepository: MovieRepository): GetMoviesUseCase {
        return GetMoviesUseCase(movieRepository)
    }

    @Provides
    fun provideUpdateMovieUseCase(movieRepository: MovieRepository): UpdateMoviesUsecase {
        return UpdateMoviesUsecase(movieRepository)
    }

    @Provides
    fun provideGetArtistUseCase(artistRepository: ArtistRepository): GetArtistsUseCase {
        return GetArtistsUseCase(artistRepository)
    }

    @Provides
    fun provideUpdateArtistUseCase(artistRepository: ArtistRepository): UpdateArtistsUseCase {
        return UpdateArtistsUseCase(artistRepository)
    }

    @Provides
    fun provideGetTvShowUseCase(tvShowRepository: TvShowRepository): GetTvShowsUseCase {
        return GetTvShowsUseCase(tvShowRepository)
    }

    @Provides
    fun provideUpdateTvShowUseCase(tvShowRepository: TvShowRepository): UpdateTvShowsUseCase {
        return UpdateTvShowsUseCase(tvShowRepository)
    }

}