package com.germanofilho.desafio.core.presenter

import io.reactivex.Observable

interface BasePresenter {

    fun <T> execute(observable : Observable<T>): Observable<T>
    fun onStop()
}