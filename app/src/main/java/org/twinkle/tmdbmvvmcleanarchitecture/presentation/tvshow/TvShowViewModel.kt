package org.twinkle.tmdbmvvmcleanarchitecture.presentation.tvshow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import org.twinkle.tmdbmvvmcleanarchitecture.domain.usecase.GetTvShowsUseCase
import org.twinkle.tmdbmvvmcleanarchitecture.domain.usecase.UpdateTvShowsUseCase

class TvShowViewModel(
    private val getTvShowsUseCase: GetTvShowsUseCase,
    private val updateTvShowsUseCase: UpdateTvShowsUseCase
): ViewModel() {

    fun getTvShows() = liveData {
        val tvShowList = getTvShowsUseCase.execute()
        emit(tvShowList)
    }

    fun updateTvShows() = liveData {
        val tvShowList = updateTvShowsUseCase.execute()
        emit(tvShowList)
    }
}