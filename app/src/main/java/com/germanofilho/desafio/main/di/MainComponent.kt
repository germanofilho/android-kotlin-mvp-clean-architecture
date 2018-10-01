package com.germanofilho.desafio.main.di

import com.germanofilho.desafio.core.di.AppScope
import com.germanofilho.desafio.main.presentation.ui.activity.MainActivity
import dagger.Subcomponent

@AppScope
@Subcomponent(
        modules = arrayOf(MainModule::class)
)
interface MainComponent {

    fun inject(activity: MainActivity)

}