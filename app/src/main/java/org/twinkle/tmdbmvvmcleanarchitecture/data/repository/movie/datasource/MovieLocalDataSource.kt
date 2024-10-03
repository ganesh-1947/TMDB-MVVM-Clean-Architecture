package org.twinkle.tmdbmvvmcleanarchitecture.data.repository.movie.datasource

import org.twinkle.tmdbmvvmcleanarchitecture.data.model.movie.Movie

interface MovieLocalDataSource {

    suspend fun getMoviesFromDataBase(): List<Movie>

    suspend fun saveMoviesToDataBase(movies: List<Movie>)

    suspend fun clearAllMovies()

}