package com.germanofilho.desafio.movie.presentation.presenter

import com.germanofilho.desafio.core.model.domain.entity.Movie
import com.germanofilho.desafio.core.presenter.BasePresenter

interface MoviePresenter : BasePresenter{
    interface MovieList : MoviePresenter{

        fun fetchMovieList()

    }

    interface Detail: MoviePresenter{
        fun saveMovieToMyList(movie : Movie)
        fun removeMovieFromMyList(movie: Movie)
        fun checkFavoriteMovie(movie: Movie)
    }
}