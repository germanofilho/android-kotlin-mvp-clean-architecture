package com.germanofilho.desafio.mylist.presentation.presenter

import com.germanofilho.desafio.core.presenter.BasePresenterImpl
import com.germanofilho.desafio.mylist.model.usecase.MyListUseCase
import com.germanofilho.desafio.mylist.presentation.ui.MyListView
import javax.inject.Inject

class MyListPresenterImpl @Inject constructor(private val mView: MyListView.Fragment) : BasePresenterImpl(mView), MyListPresenter {


    @Inject lateinit var mUseCase : MyListUseCase

    override fun fetchMyList() {
        val list = mUseCase.getMyList()
        if(list.isEmpty()){
            mView.showEmptyListText(true)
        } else {
            mView.showEmptyListText(false)
            mView.loadRecyclerView(list)
        }
    }
}