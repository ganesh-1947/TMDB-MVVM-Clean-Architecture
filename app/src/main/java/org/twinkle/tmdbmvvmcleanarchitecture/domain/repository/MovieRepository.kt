package org.twinkle.tmdbmvvmcleanarchitecture.domain.repository

import org.twinkle.tmdbmvvmcleanarchitecture.data.model.movie.Movie

interface MovieRepository {

    suspend fun getMovies():List<Movie>?
    suspend fun updateMovies():List<Movie>?

}