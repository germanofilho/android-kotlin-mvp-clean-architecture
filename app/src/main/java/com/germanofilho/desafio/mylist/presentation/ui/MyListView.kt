package com.germanofilho.desafio.mylist.presentation.ui

import com.germanofilho.desafio.core.model.domain.entity.MovieRealm
import com.germanofilho.desafio.core.view.ui.BaseView
import io.realm.RealmList

interface MyListView{

    interface Fragment : MyListView, BaseView.Fragment{
        fun loadRecyclerView(realmList: RealmList<MovieRealm>)
        fun showEmptyListText(boolean: Boolean)
    }

}