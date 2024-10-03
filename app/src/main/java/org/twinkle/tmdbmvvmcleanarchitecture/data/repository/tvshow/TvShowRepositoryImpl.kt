package org.twinkle.tmdbmvvmcleanarchitecture.data.repository.tvshow

import android.util.Log
import org.twinkle.tmdbmvvmcleanarchitecture.data.model.tvshow.TvShow
import org.twinkle.tmdbmvvmcleanarchitecture.data.repository.tvshow.datasource.TvShowCacheDataSource
import org.twinkle.tmdbmvvmcleanarchitecture.data.repository.tvshow.datasource.TvShowLocalDataSource
import org.twinkle.tmdbmvvmcleanarchitecture.data.repository.tvshow.datasource.TvShowRemoteDataSource
import org.twinkle.tmdbmvvmcleanarchitecture.domain.repository.TvShowRepository

class TvShowRepositoryImpl(
    private val tvShowRemoteDataSource: TvShowRemoteDataSource,
    private val tvShowLocalDataSource: TvShowLocalDataSource,
    private val tvShowCacheDataSource: TvShowCacheDataSource
) : TvShowRepository {
    override suspend fun getTvShows(): List<TvShow> {
        return getTvShowsFromCache()
    }

    override suspend fun updateTvShows(): List<TvShow> {
        val newListOfTvShows = getTvShowsFromApi()
        tvShowLocalDataSource.clearAllTvShows()
        tvShowLocalDataSource.saveTvShowsToDataBase(newListOfTvShows)
        tvShowCacheDataSource.saveTvShowsToCache(newListOfTvShows)
        return newListOfTvShows
    }

    suspend fun getTvShowsFromApi(): List<TvShow> {

        lateinit var tvShowList: List<TvShow>
        try {
            val response = tvShowRemoteDataSource.getTvShows()
            val body = response.body()
            if (body != null) {
                tvShowList = body.tvShows
            }
        }catch (exception: Exception) {
            Log.i("Tag", exception.message.toString())
        }
        return tvShowList
    }

    suspend fun getTvShowsFromDataBase(): List<TvShow> {

        lateinit var tvShowList: List<TvShow>
        try {
            tvShowList = tvShowLocalDataSource.getTvShowsFromDataBase()
        }catch (exception: Exception) {
            Log.i("Tag", exception.message.toString())
        }
        if (tvShowList.isNotEmpty()) {
            return tvShowList
        } else {
            tvShowList = getTvShowsFromApi()
            tvShowLocalDataSource.saveTvShowsToDataBase(tvShowList)
        }
        return tvShowList
    }

    suspend fun getTvShowsFromCache(): List<TvShow> {

        lateinit var tvShowList: List<TvShow>
        try {
            tvShowList = tvShowCacheDataSource.getTvShowsFromCache()
        }catch (exception: Exception) {
            Log.i("Tag", exception.message.toString())
        }
        if (tvShowList.isNotEmpty()) {
            return tvShowList
        } else {
            tvShowList = getTvShowsFromDataBase()
            tvShowCacheDataSource.saveTvShowsToCache(tvShowList)
        }
        return tvShowList
    }
}