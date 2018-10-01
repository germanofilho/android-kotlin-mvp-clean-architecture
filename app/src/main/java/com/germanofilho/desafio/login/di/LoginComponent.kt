package com.germanofilho.desafio.login.di

import com.germanofilho.desafio.core.di.AppScope
import com.germanofilho.desafio.login.presentation.ui.activity.LoginActivity
import dagger.Subcomponent

@AppScope
@Subcomponent(
        modules = arrayOf(LoginModule::class)
)
interface LoginComponent {

    fun inject(activity: LoginActivity)

}