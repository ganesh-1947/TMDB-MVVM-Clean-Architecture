package org.twinkle.tmdbmvvmcleanarchitecture.data.repository.movie

import android.util.Log
import org.twinkle.tmdbmvvmcleanarchitecture.data.model.movie.Movie
import org.twinkle.tmdbmvvmcleanarchitecture.data.repository.movie.datasource.MovieCacheDataSource
import org.twinkle.tmdbmvvmcleanarchitecture.data.repository.movie.datasource.MovieLocalDataSource
import org.twinkle.tmdbmvvmcleanarchitecture.data.repository.movie.datasource.MovieRemoteDataSource
import org.twinkle.tmdbmvvmcleanarchitecture.domain.repository.MovieRepository

class MovieRepositoryImpl(
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val movieLocalDataSource: MovieLocalDataSource,
    private val movieCacheDataSource: MovieCacheDataSource
): MovieRepository {

    override suspend fun getMovies(): List<Movie>? {
        return getMoviesFromCache()
    }

    override suspend fun updateMovies(): List<Movie>? {
        val newListOfMovies = getMoviesFromApi()
        movieLocalDataSource.clearAllMovies()
        movieLocalDataSource.saveMoviesToDataBase(newListOfMovies)
        movieCacheDataSource.saveMoviesToCache(newListOfMovies)
        return newListOfMovies
    }

    suspend fun getMoviesFromApi(): List<Movie> {

        lateinit var movieList: List<Movie>
        try {
            val response = movieRemoteDataSource.getMovies()
            val body = response.body()
            if (body != null) {
                movieList = body.movies
            }
        }catch (exception: Exception) {
            Log.i("Tag", exception.message.toString())
        }
        return movieList
    }

    suspend fun getMoviesFromDataBase(): List<Movie> {

        lateinit var movieList: List<Movie>
        try {
            movieList = movieLocalDataSource.getMoviesFromDataBase()
        }catch (exception: Exception) {
            Log.i("Tag", exception.message.toString())
        }
        if (movieList.isNotEmpty()) {
            return movieList
        } else {
            movieList = getMoviesFromApi()
            movieLocalDataSource.saveMoviesToDataBase(movieList)
        }
        return movieList
    }

    suspend fun getMoviesFromCache(): List<Movie> {

        lateinit var movieList: List<Movie>
        try {
            movieList = movieCacheDataSource.getMoviesFromCache()
        }catch (exception: Exception) {
            Log.i("Tag", exception.message.toString())
        }
        if (movieList.isNotEmpty()) {
            return movieList
        } else {
            movieList = getMoviesFromDataBase()
            movieCacheDataSource.saveMoviesToCache(movieList)
        }
        return movieList
    }
}