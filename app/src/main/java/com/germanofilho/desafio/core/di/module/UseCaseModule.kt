package com.germanofilho.desafio.core.di.module

import com.germanofilho.desafio.core.model.usecase.BaseUseCase
import com.germanofilho.desafio.core.model.usecase.BaseUseCaseImpl
import com.germanofilho.desafio.login.model.usecase.LoginUseCase
import com.germanofilho.desafio.login.model.usecase.LoginUseCaseImpl
import com.germanofilho.desafio.movie.model.usecase.MovieUseCase
import com.germanofilho.desafio.movie.model.usecase.MovieUseCaseImpl
import com.germanofilho.desafio.mylist.model.usecase.MyListUseCase
import com.germanofilho.desafio.mylist.model.usecase.MyListUseCaseImpl
import com.germanofilho.desafio.signup.model.usecase.SignUpUseCase
import com.germanofilho.desafio.signup.model.usecase.SignUpUseCaseImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UseCaseModule {

    @Provides
    @Singleton
    fun provideBaseUseCase(useCase: BaseUseCaseImpl): BaseUseCase = useCase

    @Provides
    @Singleton
    fun provideLoginUseCase(useCase: LoginUseCaseImpl): LoginUseCase = useCase

    @Provides
    @Singleton
    fun provideSignUpUseCase(useCase: SignUpUseCaseImpl): SignUpUseCase = useCase

    @Provides
    @Singleton
    fun provideMovieUseCase(useCase: MovieUseCaseImpl): MovieUseCase = useCase

    @Provides
    @Singleton
    fun provideMyListUseCase(useCase: MyListUseCaseImpl): MyListUseCase = useCase

}