package org.twinkle.tmdbmvvmcleanarchitecture.presentation.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.twinkle.tmdbmvvmcleanarchitecture.domain.usecase.GetMoviesUseCase
import org.twinkle.tmdbmvvmcleanarchitecture.domain.usecase.UpdateMoviesUsecase

class MovieViewModelFactory(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val updateMoviesUsecase: UpdateMoviesUsecase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MovieViewModel(getMoviesUseCase, updateMoviesUsecase) as T
    }

}