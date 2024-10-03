package org.twinkle.tmdbmvvmcleanarchitecture.data.repository.movie.datasource

import org.twinkle.tmdbmvvmcleanarchitecture.data.model.movie.Movie

interface MovieCacheDataSource {

    suspend fun getMoviesFromCache(): List<Movie>

    suspend fun saveMoviesToCache(movies: List<Movie>)

}