package org.twinkle.tmdbmvvmcleanarchitecture.presentation.tvshow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.twinkle.tmdbmvvmcleanarchitecture.domain.usecase.GetTvShowsUseCase
import org.twinkle.tmdbmvvmcleanarchitecture.domain.usecase.UpdateTvShowsUseCase

class TvShowViewModelFactory(private val getTvShowsUseCase: GetTvShowsUseCase, private val updateTvShowsUseCase: UpdateTvShowsUseCase): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TvShowViewModel(getTvShowsUseCase, updateTvShowsUseCase) as T
    }
}