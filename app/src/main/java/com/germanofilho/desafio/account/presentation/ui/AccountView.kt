package com.germanofilho.desafio.account.presentation.ui

import com.germanofilho.desafio.core.view.ui.BaseView

interface AccountView {

    interface Fragment : AccountView, BaseView.Fragment{

        fun showError()

        fun showLogoutWithSuccess()

    }

}