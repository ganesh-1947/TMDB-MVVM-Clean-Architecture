package org.twinkle.tmdbmvvmcleanarchitecture.data.repository.movie.datasource

import org.twinkle.tmdbmvvmcleanarchitecture.data.model.movie.MovieList
import retrofit2.Response

interface MovieRemoteDataSource {

    suspend fun getMovies(): Response<MovieList>
}