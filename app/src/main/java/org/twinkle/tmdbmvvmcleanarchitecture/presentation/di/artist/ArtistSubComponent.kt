package org.twinkle.tmdbmvvmcleanarchitecture.presentation.di.artist

import dagger.Subcomponent
import org.twinkle.tmdbmvvmcleanarchitecture.presentation.artist.ArtistActivity

@ArtistScope
@Subcomponent(modules = [ArtistModule::class])
interface ArtistSubComponent {
    fun inject(artistActivity: ArtistActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create(): ArtistSubComponent
    }
}