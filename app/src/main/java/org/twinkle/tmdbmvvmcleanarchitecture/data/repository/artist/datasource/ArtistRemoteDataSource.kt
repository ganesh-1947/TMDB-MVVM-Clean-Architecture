package org.twinkle.tmdbmvvmcleanarchitecture.data.repository.artist.datasource

import org.twinkle.tmdbmvvmcleanarchitecture.data.model.artist.ArtistList
import retrofit2.Response

interface ArtistRemoteDataSource {

    suspend fun getArtists(): Response<ArtistList>
}