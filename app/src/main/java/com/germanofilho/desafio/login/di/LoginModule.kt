package com.germanofilho.desafio.login.di

import com.germanofilho.desafio.core.di.AppScope
import com.germanofilho.desafio.login.presentation.presenter.LoginPresenter
import com.germanofilho.desafio.login.presentation.presenter.LoginPresenterImpl
import com.germanofilho.desafio.login.presentation.ui.LoginView
import dagger.Module
import dagger.Provides

@Module
class LoginModule(var view: LoginView) {

    @Provides
    @AppScope
    fun provideLoginView(): LoginView {
        return view
    }

    @Provides
    @AppScope
    fun provideLoginActivityView(): LoginView.Activity {
        return view as LoginView.Activity
    }

    @Provides
    @AppScope
    fun provideLoginActivityPresenter(presenter: LoginPresenterImpl): LoginPresenter {
        return presenter
    }

}