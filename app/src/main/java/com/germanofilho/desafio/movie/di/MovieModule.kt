package com.germanofilho.desafio.movie.di

import com.germanofilho.desafio.core.di.AppScope
import com.germanofilho.desafio.core.view.ui.BaseView
import com.germanofilho.desafio.movie.presentation.presenter.MovieDetailPresenterImpl
import com.germanofilho.desafio.movie.presentation.presenter.MovieListPresenterImpl
import com.germanofilho.desafio.movie.presentation.presenter.MoviePresenter
import com.germanofilho.desafio.movie.presentation.ui.MovieView
import dagger.Module
import dagger.Provides

@Module
class MovieModule constructor(var view: BaseView) {

    @Provides
    @AppScope
    fun provideMovieView(): MovieView = view as MovieView

    @Provides
    @AppScope
    fun provideMovieViewListView(): MovieView.MovieList = view as MovieView.MovieList

    @Provides
    @AppScope
    fun provideMovieViewDetailView(): MovieView.Detail = view as MovieView.Detail


    @Provides
    @AppScope
    fun provideMovieListFragmentPresenter(presenter: MovieListPresenterImpl): MoviePresenter.MovieList = presenter

    @Provides
    @AppScope
    fun provideMovieDetailFragmentPresenter(presenter: MovieDetailPresenterImpl): MoviePresenter.Detail = presenter


}