package com.germanofilho.desafio.core.model.usecase

import io.reactivex.Observable

interface BaseUseCase {

    fun <T> execute( observable: Observable<T>): Observable<T>
}