package org.twinkle.tmdbmvvmcleanarchitecture.data.repository.tvshow.datasourceimpl

import org.twinkle.tmdbmvvmcleanarchitecture.data.model.tvshow.TvShow
import org.twinkle.tmdbmvvmcleanarchitecture.data.repository.tvshow.datasource.TvShowCacheDataSource

class TvShowCacheDataSourceImpl : TvShowCacheDataSource {

    private var tvShowList = ArrayList<TvShow>()

    override suspend fun getTvShowsFromCache(): List<TvShow> {
        return tvShowList
    }

    override suspend fun saveTvShowsToCache(tvShows: List<TvShow>) {
        tvShowList.clear()
        tvShowList = ArrayList(tvShows)
    }
}