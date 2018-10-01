package com.germanofilho.desafio.signup.presentation.ui

import com.germanofilho.desafio.core.view.ui.BaseView

interface SignUpView{

    interface Activity : SignUpView, BaseView.Activity{
        fun showSaveUserErro()
    }
}