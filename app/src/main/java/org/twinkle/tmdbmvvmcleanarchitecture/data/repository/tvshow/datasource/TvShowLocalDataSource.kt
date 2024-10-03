package org.twinkle.tmdbmvvmcleanarchitecture.data.repository.tvshow.datasource

import org.twinkle.tmdbmvvmcleanarchitecture.data.model.tvshow.TvShow

interface TvShowLocalDataSource {

    suspend fun getTvShowsFromDataBase(): List<TvShow>

    suspend fun saveTvShowsToDataBase(tvShows: List<TvShow>)

    suspend fun clearAllTvShows()

}