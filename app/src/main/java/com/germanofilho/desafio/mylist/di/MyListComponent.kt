package com.germanofilho.desafio.mylist.di

import com.germanofilho.desafio.core.di.AppScope
import com.germanofilho.desafio.mylist.presentation.ui.fragment.MyListFragment
import dagger.Subcomponent

@AppScope
@Subcomponent(modules = arrayOf(MyListModule::class))
interface MyListComponent {
    fun inject(fragment: MyListFragment)
}