package org.twinkle.tmdbmvvmcleanarchitecture.data.api

import org.twinkle.tmdbmvvmcleanarchitecture.data.model.artist.ArtistList
import org.twinkle.tmdbmvvmcleanarchitecture.data.model.movie.MovieList
import org.twinkle.tmdbmvvmcleanarchitecture.data.model.tvshow.TvShowList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TMDBService {

    @GET("movie/popular")
    suspend fun getPopularMovies(@Query("api_key")apikey: String): Response<MovieList>

    @GET("tv/popular")
    suspend fun getPopularTvShows(@Query("api_key")apikey: String): Response<TvShowList>

    @GET("person/popular")
    suspend fun getPopularArtists(@Query("api_key")apikey: String): Response<ArtistList>
}