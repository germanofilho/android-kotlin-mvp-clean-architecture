package com.germanofilho.desafio.movie.di

import com.germanofilho.desafio.core.di.AppScope
import com.germanofilho.desafio.movie.presentation.ui.activity.MovieDetailActivity
import com.germanofilho.desafio.movie.presentation.ui.fragment.MovieListFragment
import dagger.Subcomponent

@AppScope
@Subcomponent(modules = arrayOf(MovieModule::class))
interface MovieComponent {
    fun inject(fragment: MovieListFragment)
    fun inject(activity : MovieDetailActivity)

}