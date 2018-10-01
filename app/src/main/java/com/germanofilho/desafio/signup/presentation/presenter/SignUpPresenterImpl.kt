package com.germanofilho.desafio.signup.presentation.presenter

import com.germanofilho.desafio.core.model.domain.entity.User
import com.germanofilho.desafio.core.presenter.BaseActivityPresenterImpl
import com.germanofilho.desafio.signup.model.usecase.SignUpUseCase
import com.germanofilho.desafio.signup.presentation.ui.SignUpView
import javax.inject.Inject

class SignUpPresenterImpl @Inject constructor(private val mView: SignUpView.Activity) : BaseActivityPresenterImpl(mView), SignUpPresenter{

    @Inject lateinit var mUseCase : SignUpUseCase

    override fun intentSaveUser(user: User) {
        if(mUseCase.saveUser(user)) mView.goToLoginActivity()
        else mView.showSaveUserErro()
    }

}