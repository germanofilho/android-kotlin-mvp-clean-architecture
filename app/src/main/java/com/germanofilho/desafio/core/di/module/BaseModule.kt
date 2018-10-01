package com.germanofilho.desafio.core.di.module

import com.germanofilho.desafio.core.presenter.BasePresenter
import com.germanofilho.desafio.core.presenter.BasePresenterImpl
import com.germanofilho.desafio.core.view.ui.BaseView
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class BaseModule constructor(private var baseView: BaseView) {

    @Provides
    @Singleton
    fun provideBaseView(): BaseView.Activity {
        return baseView as BaseView.Activity
    }


    @Provides
    @Singleton
    fun provideBaseFragmentView(): BaseView.Fragment {
        return baseView as BaseView.Fragment
    }


    @Provides
    @Singleton
    fun provideBasePresenter(presenter: BasePresenterImpl): BasePresenter {
        return presenter
    }

}