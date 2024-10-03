package org.twinkle.tmdbmvvmcleanarchitecture.data.repository.artist.datasource

import org.twinkle.tmdbmvvmcleanarchitecture.data.model.artist.Artist

interface ArtistCacheDataSource {

    suspend fun getArtistsFromCache(): List<Artist>

    suspend fun saveArtistsToCache(movies: List<Artist>)

}