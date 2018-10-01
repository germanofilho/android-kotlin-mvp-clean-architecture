package com.germanofilho.desafio.core.model.usecase

import android.util.Log
import com.germanofilho.desafio.core.model.manager.SharedPreferenceManager
import com.germanofilho.desafio.core.model.service.BaseService
import com.germanofilho.desafio.movie.model.service.MovieService
import io.reactivex.Observable
import javax.inject.Inject

open class BaseUseCaseImpl @Inject constructor(val movieService: BaseService) : BaseUseCase {


    @Inject
    lateinit var preference: SharedPreferenceManager


    override fun <T> execute(observable: Observable<T>): Observable<T> {
        return observable
                .onErrorResumeNext { throwable: Throwable ->
                    Log.e("Service", throwable.message)
                    return@onErrorResumeNext observable
                }
    }

}