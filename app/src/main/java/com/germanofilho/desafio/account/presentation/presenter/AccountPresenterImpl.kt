package com.germanofilho.desafio.account.presentation.presenter

import com.germanofilho.desafio.account.presentation.ui.AccountView
import com.germanofilho.desafio.core.presenter.BasePresenterImpl
import com.germanofilho.desafio.login.model.usecase.LoginUseCase
import javax.inject.Inject

class AccountPresenterImpl @Inject constructor(private val mView: AccountView.Fragment) : BasePresenterImpl(mView), AccountPresenter {

    @Inject lateinit var mUseCase: LoginUseCase

    override fun logoutUser() {
        mUseCase.logout()
        if(mUseCase.isLogged()) {
            mView.showError()
        }
        else {
            mView.goToLoginActivity()
            mView.showLogoutWithSuccess()
        }
    }
}