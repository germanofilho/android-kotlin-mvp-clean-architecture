package com.germanofilho.desafio.core.model.domain.entity

data class UserCredential(var user: String, var userName : String, var userKey : String) {

    companion object {
        const val USER_CREDENTIAL = "USER_CREDENTIAL"
    }
}