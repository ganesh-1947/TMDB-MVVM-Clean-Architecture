package org.twinkle.tmdbmvvmcleanarchitecture.data.repository.tvshow.datasourceimpl

import org.twinkle.tmdbmvvmcleanarchitecture.data.api.TMDBService
import org.twinkle.tmdbmvvmcleanarchitecture.data.model.tvshow.TvShowList
import org.twinkle.tmdbmvvmcleanarchitecture.data.repository.tvshow.datasource.TvShowRemoteDataSource
import retrofit2.Response

class TvShowRemoteDataSourceImpl(private val tmdbService: TMDBService, private val apiKey: String): TvShowRemoteDataSource {

    override suspend fun getTvShows(): Response<TvShowList> = tmdbService.getPopularTvShows(apiKey)

}