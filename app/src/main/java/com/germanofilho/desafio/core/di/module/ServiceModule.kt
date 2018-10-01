package com.germanofilho.desafio.core.di.module

import com.germanofilho.desafio.core.model.service.BaseService
import com.germanofilho.desafio.core.model.service.BaseServiceImpl
import com.germanofilho.desafio.movie.model.service.MovieService
import com.germanofilho.desafio.movie.model.service.MovieServiceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ServiceModule {

    @Provides
    @Singleton
    fun provideBaseService(service: BaseServiceImpl): BaseService {
        return service
    }

    @Provides
    @Singleton
    fun provideMovieService(service: MovieServiceImpl): MovieService {
        return service
    }
}
