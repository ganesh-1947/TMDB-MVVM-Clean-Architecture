package org.twinkle.tmdbmvvmcleanarchitecture.data.repository.movie.datasourceimpl

import org.twinkle.tmdbmvvmcleanarchitecture.data.model.movie.Movie
import org.twinkle.tmdbmvvmcleanarchitecture.data.repository.artist.datasource.ArtistCacheDataSource
import org.twinkle.tmdbmvvmcleanarchitecture.data.repository.movie.datasource.MovieCacheDataSource

class MovieCacheDataSourceImpl: MovieCacheDataSource {

    private var movieList = ArrayList<Movie>()

    override suspend fun getMoviesFromCache(): List<Movie> {
        return movieList
    }

    override suspend fun saveMoviesToCache(movies: List<Movie>) {
        movieList.clear()
        movieList = ArrayList(movies)
    }
}