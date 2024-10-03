package org.twinkle.tmdbmvvmcleanarchitecture.domain.usecase

import org.twinkle.tmdbmvvmcleanarchitecture.data.model.movie.Movie
import org.twinkle.tmdbmvvmcleanarchitecture.domain.repository.MovieRepository

class GetMoviesUseCase(private val movieRepository: MovieRepository) {
  suspend fun execute():List<Movie>? = movieRepository.getMovies()
}