package org.twinkle.tmdbmvvmcleanarchitecture.data.repository.movie.datasourceimpl

import org.twinkle.tmdbmvvmcleanarchitecture.data.api.TMDBService
import org.twinkle.tmdbmvvmcleanarchitecture.data.model.movie.MovieList
import org.twinkle.tmdbmvvmcleanarchitecture.data.repository.artist.datasource.ArtistRemoteDataSource
import org.twinkle.tmdbmvvmcleanarchitecture.data.repository.movie.datasource.MovieRemoteDataSource
import retrofit2.Response

class MovieRemoteDataSourceImpl(private val tmdbService: TMDBService, private val apiKey: String):
    MovieRemoteDataSource {

    override suspend fun getMovies(): Response<MovieList>  = tmdbService.getPopularMovies(apiKey)

}