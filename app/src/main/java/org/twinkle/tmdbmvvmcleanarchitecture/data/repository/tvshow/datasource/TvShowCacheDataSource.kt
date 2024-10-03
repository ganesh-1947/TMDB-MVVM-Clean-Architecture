package org.twinkle.tmdbmvvmcleanarchitecture.data.repository.tvshow.datasource

import org.twinkle.tmdbmvvmcleanarchitecture.data.model.tvshow.TvShow

interface TvShowCacheDataSource {

    suspend fun getTvShowsFromCache(): List<TvShow>

    suspend fun saveTvShowsToCache(tvShows: List<TvShow>)

}