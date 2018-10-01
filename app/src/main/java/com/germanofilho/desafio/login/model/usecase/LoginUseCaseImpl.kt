package com.germanofilho.desafio.login.model.usecase

import com.germanofilho.desafio.App
import com.germanofilho.desafio.core.model.domain.entity.User
import com.germanofilho.desafio.core.model.manager.SharedPreferenceManager
import io.realm.Realm
import javax.inject.Inject

class LoginUseCaseImpl @Inject constructor() : LoginUseCase{


    private var mRealm : Realm

    init {
        Realm.init(App.instance)
        mRealm = Realm.getDefaultInstance()
    }

    override fun login(user: String, pass: String): Boolean {
        val mUser = mRealm.where(User::class.java).contains("user", user).findAll()

        if(mUser.size != 0){
            if(mUser[0]?.pass.equals(pass)){
                SharedPreferenceManager.writeUserCredential(mUser[0])
                return true
            }
            return false
        }
        return false
    }

    override fun logout() {
        SharedPreferenceManager.writeUserCredential(null)
    }

    override fun isLogged() : Boolean{
        return SharedPreferenceManager.readUserCredential() != null
    }
}