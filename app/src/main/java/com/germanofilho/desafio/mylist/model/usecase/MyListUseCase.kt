package com.germanofilho.desafio.mylist.model.usecase

import com.germanofilho.desafio.core.model.domain.entity.Movie
import com.germanofilho.desafio.core.model.domain.entity.MovieRealm
import io.realm.RealmList

interface MyListUseCase{
    fun getMyList() : RealmList<MovieRealm>
}