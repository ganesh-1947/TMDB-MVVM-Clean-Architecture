package org.twinkle.tmdbmvvmcleanarchitecture.domain.usecase

import org.twinkle.tmdbmvvmcleanarchitecture.data.model.movie.Movie
import org.twinkle.tmdbmvvmcleanarchitecture.domain.repository.MovieRepository

class UpdateMoviesUsecase(private val movieRepository: MovieRepository) {
    suspend fun execute():List<Movie>? = movieRepository.updateMovies()
}