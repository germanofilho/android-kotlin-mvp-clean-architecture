package com.germanofilho.desafio.signup.di

import com.germanofilho.desafio.core.di.AppScope
import com.germanofilho.desafio.signup.presentation.presenter.SignUpPresenter
import com.germanofilho.desafio.signup.presentation.presenter.SignUpPresenterImpl
import com.germanofilho.desafio.signup.presentation.ui.SignUpView
import dagger.Module
import dagger.Provides

@Module
class SignUpModule(var view: SignUpView) {

    @Provides
    @AppScope
    fun provideSignUpView(): SignUpView {
        return view
    }

    @Provides
    @AppScope
    fun provideSignUpActivityView(): SignUpView.Activity {
        return view as SignUpView.Activity
    }

    @Provides
    @AppScope
    fun provideSignUpActivityPresenter(presenter: SignUpPresenterImpl): SignUpPresenter {
        return presenter
    }
}