package com.germanofilho.desafio.movie.model.service

import com.germanofilho.desafio.core.model.domain.entity.Movie
import io.reactivex.Observable
import retrofit2.http.GET

/**
 * Created on 18/06/2018
 * @author Germano Filho
 * @email germanof16@gmail.com
 */

internal interface MovieServiceEndPoint {

    @GET("movies")
    fun getMovies() : Observable<List<Movie>>

}