package org.twinkle.tmdbmvvmcleanarchitecture.presentation.di.tvshow

import dagger.Subcomponent
import org.twinkle.tmdbmvvmcleanarchitecture.presentation.tvshow.TvShowActivity

@TvShowScope
@Subcomponent(modules = [TvShowModule::class])
interface TvShowSubComponent {
    fun inject(tvShowActivity: TvShowActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create(): TvShowSubComponent
    }
}