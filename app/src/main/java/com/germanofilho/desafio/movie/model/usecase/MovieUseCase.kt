package com.germanofilho.desafio.movie.model.usecase

import com.germanofilho.desafio.core.model.domain.entity.Movie
import io.reactivex.Observable


interface MovieUseCase{
    fun getMovieList() : Observable<List<Movie>>
    fun saveMyList(movie: Movie) : Boolean
    fun removeFromMyList(movie: Movie) : Boolean
    fun checkIfExistsOnMyList(movie: Movie) : Boolean
}