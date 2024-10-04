package org.twinkle.tmdbmvvmcleanarchitecture.presentation.di.tvshow

import dagger.Module
import dagger.Provides
import org.twinkle.tmdbmvvmcleanarchitecture.domain.usecase.GetTvShowsUseCase
import org.twinkle.tmdbmvvmcleanarchitecture.domain.usecase.UpdateTvShowsUseCase
import org.twinkle.tmdbmvvmcleanarchitecture.presentation.tvshow.TvShowViewModelFactory

@Module
class TvShowModule {

    @TvShowScope
    @Provides
    fun provideTvShowViewModelFactory(
        getTvShowsUseCase: GetTvShowsUseCase,
        updateTvShowsUseCase: UpdateTvShowsUseCase
    ): TvShowViewModelFactory{
        return TvShowViewModelFactory(getTvShowsUseCase, updateTvShowsUseCase)
    }
}