package com.germanofilho.desafio.core.model.service

import com.germanofilho.desafio.BuildConfig
import javax.inject.Singleton

@Singleton
abstract class BaseServiceImpl : BaseService {

    companion object {

        fun getBaseUrl(): String {
            return BuildConfig.BASE_URL
        }

    }

}