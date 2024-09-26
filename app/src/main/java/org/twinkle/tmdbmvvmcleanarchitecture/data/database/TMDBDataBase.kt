package org.twinkle.tmdbmvvmcleanarchitecture.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import org.twinkle.tmdbmvvmcleanarchitecture.data.model.artist.Artist
import org.twinkle.tmdbmvvmcleanarchitecture.data.model.movie.Movie
import org.twinkle.tmdbmvvmcleanarchitecture.data.model.tvshow.TvShow

@Database(entities = [Movie::class, TvShow::class, Artist::class], version = 1, exportSchema = false)
abstract class TMDBDataBase : RoomDatabase() {
    abstract fun movieDao(): MovieDAO
    abstract fun tvDao(): TvShowDAO
    abstract fun artistDao(): ArtistDAO
}