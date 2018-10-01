package com.germanofilho.desafio.login.presentation.presenter

import com.germanofilho.desafio.core.presenter.BaseActivityPresenterImpl
import com.germanofilho.desafio.login.model.usecase.LoginUseCase
import com.germanofilho.desafio.login.presentation.ui.LoginView
import javax.inject.Inject

class LoginPresenterImpl @Inject constructor(private val mView : LoginView.Activity) : BaseActivityPresenterImpl(mView), LoginPresenter{

    @Inject lateinit var mUseCase : LoginUseCase

    override fun fetchUserCredential(user: String, pass: String) {
        if(mUseCase.login(user, pass)){
            return mView.gotToMainActivity()
        } else mView.showLoginError()
    }

    override fun checkAlreadyLogged() {
        if(mUseCase.isLogged()) mView.gotToMainActivity()
    }
}