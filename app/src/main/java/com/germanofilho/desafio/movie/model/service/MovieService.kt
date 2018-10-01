package com.germanofilho.desafio.movie.model.service

import com.germanofilho.desafio.core.model.domain.entity.Movie
import com.germanofilho.desafio.core.model.service.BaseService
import io.reactivex.Observable

/**
 * Created on 18/06/2018
 * @author Germano Filho
 * @email germanof16@gmail.com
 */

interface MovieService : BaseService{
    fun getMovieList() : Observable<List<Movie>>
}