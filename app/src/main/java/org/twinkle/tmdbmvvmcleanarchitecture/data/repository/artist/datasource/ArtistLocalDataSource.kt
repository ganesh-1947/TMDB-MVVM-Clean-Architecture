package org.twinkle.tmdbmvvmcleanarchitecture.data.repository.artist.datasource

import org.twinkle.tmdbmvvmcleanarchitecture.data.model.artist.Artist

interface ArtistLocalDataSource {

    suspend fun getArtistFromDataBase(): List<Artist>

    suspend fun saveArtistToDataBase(artists: List<Artist>)

    suspend fun clearAllArtists()

}