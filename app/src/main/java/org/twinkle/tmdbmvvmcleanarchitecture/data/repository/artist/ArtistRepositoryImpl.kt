package org.twinkle.tmdbmvvmcleanarchitecture.data.repository.artist

import android.util.Log
import org.twinkle.tmdbmvvmcleanarchitecture.data.model.artist.Artist
import org.twinkle.tmdbmvvmcleanarchitecture.data.repository.artist.datasource.ArtistCacheDataSource
import org.twinkle.tmdbmvvmcleanarchitecture.data.repository.artist.datasource.ArtistLocalDataSource
import org.twinkle.tmdbmvvmcleanarchitecture.data.repository.artist.datasource.ArtistRemoteDataSource
import org.twinkle.tmdbmvvmcleanarchitecture.domain.repository.ArtistRepository

class ArtistRepositoryImpl(
    private val movieRemoteDataSource: ArtistRemoteDataSource,
    private val movieLocalDataSource: ArtistLocalDataSource,
    private val movieCacheDataSource: ArtistCacheDataSource
): ArtistRepository {

    override suspend fun getArtists(): List<Artist> {
        return getArtistsFromCache()
    }

    override suspend fun updateArtists(): List<Artist> {
        val newListOfMovies = getArtistsFromApi()
        movieLocalDataSource.clearAllArtists()
        movieLocalDataSource.saveArtistToDataBase(newListOfMovies)
        movieCacheDataSource.saveArtistsToCache(newListOfMovies)
        return newListOfMovies
    }

    private suspend fun getArtistsFromApi(): List<Artist> {

        lateinit var artistList: List<Artist>
        try {
            val response = movieRemoteDataSource.getArtists()
            val body = response.body()
            if (body != null) {
                artistList = body.artists
            }
        }catch (exception: Exception) {
            Log.i("Tag", exception.message.toString())
        }
        return artistList
    }

    private suspend fun getArtistFromDataBase(): List<Artist> {

        lateinit var artistList: List<Artist>
        try {
            artistList = movieLocalDataSource.getArtistFromDataBase()
        }catch (exception: Exception) {
            Log.i("Tag", exception.message.toString())
        }
        if (artistList.isNotEmpty()) {
            return artistList
        } else {
            artistList = getArtistsFromApi()
            movieLocalDataSource.saveArtistToDataBase(artistList)
        }
        return artistList
    }

    private suspend fun getArtistsFromCache(): List<Artist> {

        lateinit var artistList: List<Artist>
        try {
            artistList = movieCacheDataSource.getArtistsFromCache()
        }catch (exception: Exception) {
            Log.i("Tag", exception.message.toString())
        }
        if (artistList.isNotEmpty()) {
            return artistList
        } else {
            artistList = getArtistFromDataBase()
            movieCacheDataSource.saveArtistsToCache(artistList)
        }
        return artistList
    }
}