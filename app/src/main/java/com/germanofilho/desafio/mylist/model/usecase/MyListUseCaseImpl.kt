package com.germanofilho.desafio.mylist.model.usecase

import com.germanofilho.desafio.App
import com.germanofilho.desafio.core.model.domain.entity.MovieRealm
import com.germanofilho.desafio.core.model.domain.entity.User
import com.germanofilho.desafio.core.model.manager.SharedPreferenceManager
import io.realm.Realm
import io.realm.RealmList
import javax.inject.Inject

class MyListUseCaseImpl @Inject constructor() : MyListUseCase{

    private var mRealm : Realm

    init {
        Realm.init(App.instance)
        mRealm = Realm.getDefaultInstance()
    }

    override fun getMyList() : RealmList<MovieRealm> {
        val mUser = mRealm.where(User::class.java).contains("userKey", SharedPreferenceManager.readUserCredential()!!.userKey).findFirst()
        return mUser!!.movies!!
    }
}