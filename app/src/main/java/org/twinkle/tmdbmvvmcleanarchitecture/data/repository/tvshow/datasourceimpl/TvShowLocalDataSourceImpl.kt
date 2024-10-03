package org.twinkle.tmdbmvvmcleanarchitecture.data.repository.tvshow.datasourceimpl

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.twinkle.tmdbmvvmcleanarchitecture.data.database.TvShowDAO
import org.twinkle.tmdbmvvmcleanarchitecture.data.model.tvshow.TvShow
import org.twinkle.tmdbmvvmcleanarchitecture.data.repository.tvshow.datasource.TvShowLocalDataSource

class TvShowLocalDataSourceImpl(private val tvShowDAO: TvShowDAO): TvShowLocalDataSource {
    override suspend fun getTvShowsFromDataBase(): List<TvShow> {
        return tvShowDAO.getTvShow()
    }

    override suspend fun saveTvShowsToDataBase(tvShows: List<TvShow>) {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDAO.saveTvShow(tvShows)
        }
    }

    override suspend fun clearAllTvShows() {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDAO.deleteAllTvShow()
        }
    }
}