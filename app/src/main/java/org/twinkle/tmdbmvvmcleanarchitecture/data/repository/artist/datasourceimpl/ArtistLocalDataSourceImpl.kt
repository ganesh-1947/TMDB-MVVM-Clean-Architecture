package org.twinkle.tmdbmvvmcleanarchitecture.data.repository.artist.datasourceimpl

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.twinkle.tmdbmvvmcleanarchitecture.data.database.ArtistDAO
import org.twinkle.tmdbmvvmcleanarchitecture.data.model.artist.Artist
import org.twinkle.tmdbmvvmcleanarchitecture.data.repository.artist.datasource.ArtistLocalDataSource

class ArtistLocalDataSourceImpl(private val artistDAO: ArtistDAO): ArtistLocalDataSource {
    override suspend fun getArtistFromDataBase(): List<Artist> {
        return artistDAO.getArtists()
    }

    override suspend fun saveArtistToDataBase(artists: List<Artist>) {
        CoroutineScope(Dispatchers.IO).launch {
            artistDAO.saveArtists(artists)
        }
    }

    override suspend fun clearAllArtists() {
        CoroutineScope(Dispatchers.IO).launch {
            artistDAO.deleteAllArtists()
        }
    }
}