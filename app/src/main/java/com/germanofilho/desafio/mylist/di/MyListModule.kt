package com.germanofilho.desafio.mylist.di

import com.germanofilho.desafio.core.di.AppScope
import com.germanofilho.desafio.core.view.ui.BaseView
import com.germanofilho.desafio.mylist.presentation.presenter.MyListPresenter
import com.germanofilho.desafio.mylist.presentation.presenter.MyListPresenterImpl
import com.germanofilho.desafio.mylist.presentation.ui.MyListView
import dagger.Module
import dagger.Provides

@Module
class MyListModule constructor(var view: BaseView) {

    @Provides
    @AppScope
    fun provideMyListView(): MyListView = view as MyListView

    @Provides
    @AppScope
    fun provideMyListViewFragmentView(): MyListView.Fragment = view as MyListView.Fragment

    @Provides
    @AppScope
    fun provideMyListPresenter(presenter: MyListPresenterImpl): MyListPresenter = presenter

}