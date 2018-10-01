package com.germanofilho.desafio.core.presenter

import com.germanofilho.desafio.core.view.ui.BaseView
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

open class BasePresenterImpl @Inject constructor(private val baseView: BaseView): BasePresenter{

    var mCompositeDisposable = CompositeDisposable()

    override fun <T> execute(observable: Observable<T>): Observable<T> {
        return observable
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorResumeNext { throwable: Throwable ->
                    return@onErrorResumeNext Observable.error(throwable)
                }
    }

    override fun onStop() {
        mCompositeDisposable.clear()
    }
}