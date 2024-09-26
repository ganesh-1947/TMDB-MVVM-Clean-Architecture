package org.twinkle.tmdbmvvmcleanarchitecture.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import org.twinkle.tmdbmvvmcleanarchitecture.data.model.tvshow.TvShow

@Dao
interface TvShowDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTvShow(movies: List<TvShow>)

    @Query("DELETE FROM popular_tv_shows")
    suspend fun deleteAllTvShow()

    @Query("SELECT * FROM popular_tv_shows")
    suspend fun getTvShow(): List<TvShow>
}