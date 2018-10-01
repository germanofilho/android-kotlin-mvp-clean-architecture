package com.germanofilho.desafio.signup.presentation.presenter

import com.germanofilho.desafio.core.model.domain.entity.User
import com.germanofilho.desafio.core.presenter.BasePresenter

interface SignUpPresenter : BasePresenter{
    fun intentSaveUser(user: User)
}