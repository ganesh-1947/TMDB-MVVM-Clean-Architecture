package org.twinkle.tmdbmvvmcleanarchitecture.data.repository.tvshow.datasource

import org.twinkle.tmdbmvvmcleanarchitecture.data.model.tvshow.TvShowList
import retrofit2.Response

interface TvShowRemoteDataSource {

    suspend fun getTvShows(): Response<TvShowList>

}