package org.twinkle.tmdbmvvmcleanarchitecture.domain.usecase

import org.twinkle.tmdbmvvmcleanarchitecture.domain.repository.ArtistRepository
import org.twinkle.tmdbmvvmcleanarchitecture.data.model.artist.Artist

class GetArtistsUseCase(private val artistRepository: ArtistRepository) {
    suspend fun execute():List<Artist>? = artistRepository.getArtists()

}