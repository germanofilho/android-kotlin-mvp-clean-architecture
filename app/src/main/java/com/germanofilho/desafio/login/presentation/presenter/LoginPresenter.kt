package com.germanofilho.desafio.login.presentation.presenter

import com.germanofilho.desafio.core.presenter.BasePresenter

interface LoginPresenter : BasePresenter {

    fun fetchUserCredential(user: String, pass : String)

    fun checkAlreadyLogged()
}