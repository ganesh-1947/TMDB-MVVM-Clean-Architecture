package org.twinkle.tmdbmvvmcleanarchitecture.data.repository.artist.datasourceimpl

import org.twinkle.tmdbmvvmcleanarchitecture.data.model.artist.Artist
import org.twinkle.tmdbmvvmcleanarchitecture.data.repository.artist.datasource.ArtistCacheDataSource

class ArtistCacheDataSourceImpl: ArtistCacheDataSource {

    private var artistList = ArrayList<Artist>()

    override suspend fun getArtistsFromCache(): List<Artist> {
        return artistList
    }

    override suspend fun saveArtistsToCache(artists: List<Artist>) {
        artistList.clear()
        artistList = ArrayList(artists)
    }
}