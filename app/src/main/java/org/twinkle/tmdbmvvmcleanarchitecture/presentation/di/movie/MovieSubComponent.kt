package org.twinkle.tmdbmvvmcleanarchitecture.presentation.di.movie

import dagger.Subcomponent
import org.twinkle.tmdbmvvmcleanarchitecture.presentation.movie.MovieActivity

@MovieScope
@Subcomponent(modules = [MovieModule::class])
interface MovieSubComponent {
    fun inject(movieActivity: MovieActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create(): MovieSubComponent
    }
}