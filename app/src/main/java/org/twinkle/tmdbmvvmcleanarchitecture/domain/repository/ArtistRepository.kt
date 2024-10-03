package org.twinkle.tmdbmvvmcleanarchitecture.domain.repository

import org.twinkle.tmdbmvvmcleanarchitecture.data.model.artist.Artist

interface ArtistRepository {
    suspend fun getArtists():List<Artist>?
    suspend fun updateArtists():List<Artist>?
}