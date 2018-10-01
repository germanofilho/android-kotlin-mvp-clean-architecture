package com.germanofilho.desafio.signup.model.usecase

import com.germanofilho.desafio.core.model.domain.entity.User
import com.germanofilho.desafio.core.model.manager.SharedPreferenceManager
import com.germanofilho.desafio.core.util.UserUtil
import com.vicpin.krealmextensions.save
import javax.inject.Inject

class SignUpUseCaseImpl @Inject constructor() : SignUpUseCase{
    
    override fun saveUser(user: User) : Boolean{
        return try {
            val userKey = UserUtil.generateUserKey()
            val mUser = User(user.name, user.user, user.pass, userKey, null)
            mUser.save()
            SharedPreferenceManager.writeUserCredential(mUser)
            true
        } catch (e : Exception){
            false
        }
    }


}