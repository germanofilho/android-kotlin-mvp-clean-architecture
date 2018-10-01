package com.germanofilho.desafio.movie.model.service

import com.germanofilho.desafio.core.model.domain.entity.Movie
import com.germanofilho.desafio.core.model.service.BaseServiceConnector
import com.germanofilho.desafio.core.model.service.BaseServiceImpl
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created on 18/06/2018
 * @author Germano Filho
 * @email germanof16@gmail.com
 */

class MovieServiceImpl @Inject constructor(var retrofit : BaseServiceConnector): BaseServiceImpl(), MovieService{
    override fun getMovieList(): Observable<List<Movie>> = retrofit.request(getBaseUrl(), MovieServiceEndPoint::class.java).getMovies()
}