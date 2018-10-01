package com.germanofilho.desafio.core.model.domain.entity

import io.realm.RealmObject
import io.realm.RealmResults
import io.realm.annotations.LinkingObjects

open class MovieRealm : RealmObject(){

    var title : String = ""
    var originalTitle : String = ""
    var duration: Int = 0
    var synopsis: String = ""
    var thumbUrl: String = ""
    var posterUrl: String = ""


    @LinkingObjects("movies")
    val movies: RealmResults<User>? = null
}