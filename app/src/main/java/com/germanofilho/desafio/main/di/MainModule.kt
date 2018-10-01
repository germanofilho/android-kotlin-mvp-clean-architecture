package com.germanofilho.desafio.main.di

import com.germanofilho.desafio.core.di.AppScope
import com.germanofilho.desafio.core.view.ui.BaseView
import com.germanofilho.desafio.main.presentation.presenter.MainPresenter
import com.germanofilho.desafio.main.presentation.presenter.MainPresenterImpl
import com.germanofilho.desafio.main.presentation.ui.MainView
import dagger.Module
import dagger.Provides

@Module
class MainModule(var view: BaseView) {

    @AppScope
    @Provides
    fun provideView(): MainView {
        return view as MainView
    }

    @AppScope
    @Provides
    fun provideActivityView(): MainView.Activity {
        return view as MainView.Activity
    }

    @AppScope
    @Provides
    fun provideMainActivityPresenter(presenter: MainPresenterImpl) : MainPresenter {
        return presenter
    }

}