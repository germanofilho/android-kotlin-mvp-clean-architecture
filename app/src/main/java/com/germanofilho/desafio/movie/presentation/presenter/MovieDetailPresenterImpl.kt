package com.germanofilho.desafio.movie.presentation.presenter

import com.germanofilho.desafio.core.model.domain.entity.Movie
import com.germanofilho.desafio.core.presenter.BasePresenterImpl
import com.germanofilho.desafio.movie.model.usecase.MovieUseCase
import com.germanofilho.desafio.movie.presentation.ui.MovieView
import javax.inject.Inject

class MovieDetailPresenterImpl @Inject constructor(private val mView: MovieView.Detail) : BasePresenterImpl(mView), MoviePresenter.Detail {


    @Inject lateinit var mUseCase : MovieUseCase

    override fun saveMovieToMyList(movie: Movie) {
        if(mUseCase.saveMyList(movie)) {
            mView.changeTextFavorite(false)
            mView.changeFavoriteOnClickAction(false)
            mView.showSavedWithSuccess()
        }
        else {
            mView.showError()
        }
    }


    override fun removeMovieFromMyList(movie: Movie) {
        if(mUseCase.removeFromMyList(movie)){
            mView.changeTextFavorite(true)
            mView.changeFavoriteOnClickAction(true)
            mView.showRemovedWithSucess()
        } else {
            mView.showError()
        }
    }

    override fun checkFavoriteMovie(movie: Movie) {
        if(mUseCase.checkIfExistsOnMyList(movie)){
            mView.changeTextFavorite(false)
            mView.changeFavoriteOnClickAction(false)
        } else {
            mView.changeTextFavorite(true)
            mView.changeFavoriteOnClickAction(true)
        }
    }
}