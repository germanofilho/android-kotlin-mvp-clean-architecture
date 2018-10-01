package com.germanofilho.desafio.core.util

import com.germanofilho.desafio.core.model.domain.entity.Movie
import com.germanofilho.desafio.core.model.domain.entity.MovieRealm

open class MovieConverter{
    companion object {
        fun fromRealm(movie : MovieRealm) : Movie {
            return Movie(movie.title, movie.originalTitle, movie.duration, movie.synopsis, movie.thumbUrl, movie.posterUrl)
        }
    }


}