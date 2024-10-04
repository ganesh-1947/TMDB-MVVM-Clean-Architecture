package org.twinkle.tmdbmvvmcleanarchitecture.presentation.di

import org.twinkle.tmdbmvvmcleanarchitecture.presentation.di.artist.ArtistSubComponent
import org.twinkle.tmdbmvvmcleanarchitecture.presentation.di.movie.MovieSubComponent
import org.twinkle.tmdbmvvmcleanarchitecture.presentation.di.tvshow.TvShowSubComponent

interface Injector {

    fun createMovieSubComponent():MovieSubComponent
    fun createTvShowSubComponent():TvShowSubComponent
    fun createArtistSubComponent():ArtistSubComponent

}