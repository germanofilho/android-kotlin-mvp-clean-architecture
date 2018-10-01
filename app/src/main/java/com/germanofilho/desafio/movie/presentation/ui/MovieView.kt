package com.germanofilho.desafio.movie.presentation.ui

import com.germanofilho.desafio.core.model.domain.entity.Movie
import com.germanofilho.desafio.core.view.ui.BaseView

interface MovieView {
    interface MovieList : MovieView, BaseView.Fragment{

        fun loadRecyclerView(movies : List<Movie>)
    }


    interface Detail : MovieView, BaseView.Activity{
        fun loadMovieData()
        fun showSavedWithSuccess()
        fun showRemovedWithSucess()
        fun showError()
        fun changeTextFavorite(boolean: Boolean)
        fun changeFavoriteOnClickAction(boolean: Boolean)
    }
}