package com.germanofilho.desafio.core.model.service

import com.germanofilho.desafio.App
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Inject

open class BaseServiceConnector @Inject constructor(protected var retrofit: Retrofit.Builder){

    private var cacheSize = 10 * 1024 * 1024// 10 MB
    var cache = Cache(App.instance.cacheDir, cacheSize.toLong())

    open fun <S> request(url: String, service: Class<S>): S {
        return retrofit
                .baseUrl(url)
                .client(providesOkHttpClient())
                .build()
                .create(service)
    }

    private fun providesOkHttpClient() : OkHttpClient{
        return OkHttpClient.Builder().cache(cache).build()
    }
}