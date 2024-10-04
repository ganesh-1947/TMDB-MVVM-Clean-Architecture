package org.twinkle.tmdbmvvmcleanarchitecture.presentation.di.core

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import org.twinkle.tmdbmvvmcleanarchitecture.data.database.ArtistDAO
import org.twinkle.tmdbmvvmcleanarchitecture.data.database.MovieDAO
import org.twinkle.tmdbmvvmcleanarchitecture.data.database.TMDBDataBase
import org.twinkle.tmdbmvvmcleanarchitecture.data.database.TvShowDAO
import javax.inject.Singleton

@Module
class DataBaseModule {
    @Singleton
    @Provides
    fun provideMovieDataBase(context: Context): TMDBDataBase {
        return Room.databaseBuilder(context, TMDBDataBase::class.java, "tmdbclient").build()
    }

    @Singleton
    @Provides
    fun provideMovieDao(tmdbDataBase: TMDBDataBase): MovieDAO {
        return tmdbDataBase.movieDao()
    }

    @Singleton
    @Provides
    fun provideArtistDao(tmdbDataBase: TMDBDataBase): ArtistDAO {
        return tmdbDataBase.artistDao()
    }

    @Singleton
    @Provides
    fun provideTvShowDao(tmdbDataBase: TMDBDataBase): TvShowDAO {
        return tmdbDataBase.tvDao()
    }

}