package org.twinkle.tmdbmvvmcleanarchitecture.domain.usecase

import org.twinkle.tmdbmvvmcleanarchitecture.data.model.tvshow.TvShow
import org.twinkle.tmdbmvvmcleanarchitecture.domain.repository.TvShowRepository

class UpdateTvShowsUseCase(private val tvShowRepository: TvShowRepository) {
    suspend fun execute():List<TvShow>?=tvShowRepository.updateTvShows()
}