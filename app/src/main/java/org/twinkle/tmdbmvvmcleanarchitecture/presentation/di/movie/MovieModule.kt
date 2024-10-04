package org.twinkle.tmdbmvvmcleanarchitecture.presentation.di.movie

import dagger.Module
import dagger.Provides
import org.twinkle.tmdbmvvmcleanarchitecture.domain.usecase.GetMoviesUseCase
import org.twinkle.tmdbmvvmcleanarchitecture.domain.usecase.UpdateMoviesUsecase
import org.twinkle.tmdbmvvmcleanarchitecture.presentation.movie.MovieViewModelFactory

@Module
class MovieModule {

    @MovieScope
    @Provides
    fun provideMovieViewModelFactory(
        getMoviesUseCase: GetMoviesUseCase,
        updateMoviesUsecase: UpdateMoviesUsecase
    ): MovieViewModelFactory {
        return MovieViewModelFactory(getMoviesUseCase, updateMoviesUsecase)
    }

}