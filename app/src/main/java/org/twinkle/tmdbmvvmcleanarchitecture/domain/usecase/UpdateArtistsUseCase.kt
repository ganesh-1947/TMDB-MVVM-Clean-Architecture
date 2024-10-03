package org.twinkle.tmdbmvvmcleanarchitecture.domain.usecase

import org.twinkle.tmdbmvvmcleanarchitecture.data.model.artist.Artist
import org.twinkle.tmdbmvvmcleanarchitecture.domain.repository.ArtistRepository

class UpdateArtistsUseCase(private val artistRepository: ArtistRepository) {
    suspend fun execute():List<Artist>? = artistRepository.updateArtists()
}