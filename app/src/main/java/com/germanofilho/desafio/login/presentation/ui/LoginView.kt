package com.germanofilho.desafio.login.presentation.ui

import com.germanofilho.desafio.core.view.ui.BaseView

interface LoginView {

    interface Activity : LoginView, BaseView.Activity{

        fun doLogin()

        fun goToSignUpActivity()

        fun showLoginError()
    }
}