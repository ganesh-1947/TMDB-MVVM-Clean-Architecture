package org.twinkle.tmdbmvvmcleanarchitecture.presentation.di.artist

import dagger.Module
import dagger.Provides
import org.twinkle.tmdbmvvmcleanarchitecture.domain.usecase.GetArtistsUseCase
import org.twinkle.tmdbmvvmcleanarchitecture.domain.usecase.UpdateArtistsUseCase
import org.twinkle.tmdbmvvmcleanarchitecture.presentation.artist.ArtistViewModelFactory

@Module
class ArtistModule {

    @ArtistScope
    @Provides
    fun provideArtistViewModelFactory(
        getArtistsUseCase: GetArtistsUseCase,
        updateArtistsUseCase: UpdateArtistsUseCase
    ): ArtistViewModelFactory {
        return ArtistViewModelFactory(getArtistsUseCase, updateArtistsUseCase)
    }

}