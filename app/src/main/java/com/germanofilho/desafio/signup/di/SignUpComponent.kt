package com.germanofilho.desafio.signup.di

import com.germanofilho.desafio.core.di.AppScope
import com.germanofilho.desafio.signup.presentation.ui.activity.SignUpActivity
import dagger.Subcomponent

@AppScope
@Subcomponent(
        modules = arrayOf(SignUpModule::class)
)
interface SignUpComponent {
    fun inject(activity: SignUpActivity)
}