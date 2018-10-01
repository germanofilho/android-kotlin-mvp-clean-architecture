package com.germanofilho.desafio.core.di.module

import com.germanofilho.desafio.core.model.service.BaseServiceConnector
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Singleton
@Module
open class NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit.Builder {
        return Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(
                        GsonConverterFactory.create(
                                GsonBuilder()
                                        .setLenient()
                                        .create())
                )
    }

    @Provides
    @Singleton
    fun provideBaseServiceConnector(retrofit: Retrofit.Builder): BaseServiceConnector {
        return BaseServiceConnector(retrofit)
    }
}

