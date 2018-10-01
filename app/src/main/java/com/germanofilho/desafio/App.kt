package com.germanofilho.desafio

import android.app.Application
import android.content.Context
import com.germanofilho.desafio.core.di.component.AppComponent
import com.germanofilho.desafio.core.di.component.DaggerAppComponent
import com.germanofilho.desafio.core.di.module.AppModule
import com.germanofilho.desafio.core.di.module.NetworkModule
import com.germanofilho.desafio.core.model.manager.SharedPreferenceManager

open class App : Application() {

    private lateinit var mAppComponent: AppComponent

    companion object {
        lateinit var instance: App
            private set

        fun get(context: Context): App = context.applicationContext as App

    }


    override fun onCreate() {
        super.onCreate()
        instance = this

        initDagger()
        SharedPreferenceManager.initialize(applicationContext)
    }


    fun getAppComponent(): AppComponent = mAppComponent



    open fun initDagger() {
        mAppComponent = DaggerAppComponent
                .builder()
                .appModule(AppModule(this))
                .networkModule(NetworkModule())
                .build()
    }
}