package com.germanofilho.desafio.core.model.domain.entity

import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class User(var name: String,
                var user: String,
                var pass: String,
                @PrimaryKey var userKey: String,
                var movies: RealmList<MovieRealm>? = RealmList()) : RealmObject() {

    constructor() : this("", "", "", "", null)

    companion object {
        const val USER_DATA = "USER_DATA"
    }
}