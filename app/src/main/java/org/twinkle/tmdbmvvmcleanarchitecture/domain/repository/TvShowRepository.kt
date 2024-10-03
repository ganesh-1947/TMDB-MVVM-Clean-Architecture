package org.twinkle.tmdbmvvmcleanarchitecture.domain.repository

import org.twinkle.tmdbmvvmcleanarchitecture.data.model.tvshow.TvShow

interface TvShowRepository {
    suspend fun getTvShows():List<TvShow>?
    suspend fun updateTvShows():List<TvShow>?
}