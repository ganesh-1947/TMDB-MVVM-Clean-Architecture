package org.twinkle.tmdbmvvmcleanarchitecture.data.repository.artist.datasourceimpl

import org.twinkle.tmdbmvvmcleanarchitecture.data.api.TMDBService
import org.twinkle.tmdbmvvmcleanarchitecture.data.model.artist.ArtistList
import org.twinkle.tmdbmvvmcleanarchitecture.data.repository.artist.datasource.ArtistRemoteDataSource
import retrofit2.Response

class ArtistRemoteDataSourceImpl(private val tmdbService: TMDBService, private val apiKey: String): ArtistRemoteDataSource {

    override suspend fun getArtists(): Response<ArtistList> = tmdbService.getPopularArtists(apiKey)

}