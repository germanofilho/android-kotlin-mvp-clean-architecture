package com.germanofilho.desafio.core.view.ui

interface BaseView {

    fun goToLoginActivity()

    fun gotToMainActivity()

    fun isToShowProgressBar(value: Boolean)

    interface Activity : BaseView {
        fun isTablet()
    }


    interface Fragment : BaseView{


    }

}