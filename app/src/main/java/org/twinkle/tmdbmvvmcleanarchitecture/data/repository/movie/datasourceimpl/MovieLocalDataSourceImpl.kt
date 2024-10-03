package org.twinkle.tmdbmvvmcleanarchitecture.data.repository.movie.datasourceimpl

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.twinkle.tmdbmvvmcleanarchitecture.data.database.MovieDAO
import org.twinkle.tmdbmvvmcleanarchitecture.data.model.movie.Movie
import org.twinkle.tmdbmvvmcleanarchitecture.data.repository.artist.datasource.ArtistLocalDataSource
import org.twinkle.tmdbmvvmcleanarchitecture.data.repository.movie.datasource.MovieLocalDataSource

class MovieLocalDataSourceImpl(private val movieDAO: MovieDAO): MovieLocalDataSource {
    override suspend fun getMoviesFromDataBase(): List<Movie> {
        return movieDAO.getMovies()
    }

    override suspend fun saveMoviesToDataBase(movies: List<Movie>) {
        CoroutineScope(Dispatchers.IO).launch {
            movieDAO.saveMovies(movies)
        }
    }

    override suspend fun clearAllMovies() {
        CoroutineScope(Dispatchers.IO).launch {
            movieDAO.deleteAllMovies()
        }
    }
}