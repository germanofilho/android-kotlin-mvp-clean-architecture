package com.germanofilho.desafio.core.di.module

import android.app.Application
import android.preference.PreferenceManager
import com.germanofilho.desafio.core.model.manager.SharedPreferenceManager
import com.germanofilho.desafio.core.model.service.BaseService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = arrayOf(
        NetworkModule::class,
        UseCaseModule::class,
        ServiceModule::class
))
open class AppModule constructor(val application: Application) {

    @Provides
    @Singleton
    fun provideApplication() = application


    @Provides
    @Singleton
    fun provideSharedPreference(app: Application): SharedPreferenceManager {
        val preferences = PreferenceManager.getDefaultSharedPreferences(app)
        return SharedPreferenceManager
    }
}