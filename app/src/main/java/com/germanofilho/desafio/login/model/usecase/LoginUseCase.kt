package com.germanofilho.desafio.login.model.usecase

interface LoginUseCase{
    fun login(user: String, pass: String) : Boolean
    fun isLogged() : Boolean
    fun logout()
}