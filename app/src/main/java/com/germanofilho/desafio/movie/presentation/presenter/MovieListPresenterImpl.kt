package com.germanofilho.desafio.movie.presentation.presenter

import android.util.Log
import com.germanofilho.desafio.core.presenter.BasePresenterImpl
import com.germanofilho.desafio.movie.model.usecase.MovieUseCase
import com.germanofilho.desafio.movie.presentation.ui.MovieView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MovieListPresenterImpl @Inject constructor(private val mView: MovieView.MovieList) : BasePresenterImpl(mView), MoviePresenter.MovieList {

    @Inject lateinit var mUseCase: MovieUseCase

    override fun fetchMovieList() {
            mView.isToShowProgressBar(true)
            val observable = execute(mUseCase.getMovieList())
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({
                        mView.isToShowProgressBar(false)
                        mView.loadRecyclerView(it)

                    }, {
                        mView.isToShowProgressBar(false)
                        Log.e("Service", it.message)
                    })


            mCompositeDisposable.add(observable)
    }
}