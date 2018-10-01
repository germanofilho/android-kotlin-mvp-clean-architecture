package com.germanofilho.desafio.core.di.component

import com.germanofilho.desafio.App
import com.germanofilho.desafio.account.di.AccountComponent
import com.germanofilho.desafio.account.di.AccountModule
import com.germanofilho.desafio.core.di.module.AppModule
import com.germanofilho.desafio.core.di.module.BaseModule
import com.germanofilho.desafio.login.di.LoginComponent
import com.germanofilho.desafio.login.di.LoginModule
import com.germanofilho.desafio.main.di.MainComponent
import com.germanofilho.desafio.main.di.MainModule
import com.germanofilho.desafio.movie.di.MovieComponent
import com.germanofilho.desafio.movie.di.MovieModule
import com.germanofilho.desafio.mylist.di.MyListComponent
import com.germanofilho.desafio.mylist.di.MyListModule
import com.germanofilho.desafio.signup.di.SignUpComponent
import com.germanofilho.desafio.signup.di.SignUpModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(
        AppModule::class,
        BaseModule::class
)
)
interface AppComponent {
    fun inject(app: App)
    fun plus(module: LoginModule): LoginComponent
    fun plus(module: SignUpModule): SignUpComponent
    fun plus(module: AccountModule): AccountComponent
    fun plus(module: MovieModule): MovieComponent
    fun plus(module: MyListModule): MyListComponent
    fun plus(module: MainModule): MainComponent
}