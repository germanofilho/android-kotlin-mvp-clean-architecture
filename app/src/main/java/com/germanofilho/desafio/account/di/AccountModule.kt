package com.germanofilho.desafio.account.di

import com.germanofilho.desafio.account.presentation.presenter.AccountPresenter
import com.germanofilho.desafio.account.presentation.presenter.AccountPresenterImpl
import com.germanofilho.desafio.account.presentation.ui.AccountView
import com.germanofilho.desafio.core.di.AppScope
import com.germanofilho.desafio.core.view.ui.BaseView
import dagger.Module
import dagger.Provides

@Module
class AccountModule constructor(var view: BaseView) {

    @Provides
    @AppScope
    fun provideAccountView(): AccountView = view as AccountView

    @Provides
    @AppScope
    fun provideAccountFragmentView(): AccountView.Fragment = view as AccountView.Fragment

    @Provides
    @AppScope
    fun provideAccountPresenter(presenter: AccountPresenterImpl): AccountPresenter = presenter

}