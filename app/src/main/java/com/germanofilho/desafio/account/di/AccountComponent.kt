package com.germanofilho.desafio.account.di

import com.germanofilho.desafio.account.presentation.ui.fragment.AccountFragment
import com.germanofilho.desafio.core.di.AppScope
import dagger.Subcomponent

@AppScope
@Subcomponent(modules = arrayOf(AccountModule::class))
interface AccountComponent {

    fun inject(fragment: AccountFragment)

}