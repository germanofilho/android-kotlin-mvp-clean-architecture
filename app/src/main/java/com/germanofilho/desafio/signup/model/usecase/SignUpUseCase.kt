package com.germanofilho.desafio.signup.model.usecase

import com.germanofilho.desafio.core.model.domain.entity.User

interface SignUpUseCase {
    fun saveUser(user: User): Boolean
}