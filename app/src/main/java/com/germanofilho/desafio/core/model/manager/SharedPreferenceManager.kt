package com.germanofilho.desafio.core.model.manager

import android.content.Context
import android.content.SharedPreferences
import com.germanofilho.desafio.BuildConfig
import com.germanofilho.desafio.core.model.domain.entity.User
import com.germanofilho.desafio.core.model.domain.entity.UserCredential
import com.google.gson.Gson

object SharedPreferenceManager {

    private lateinit var mPreference: SharedPreferences

    fun initialize(context: Context) {
        mPreference = context.getSharedPreferences(BuildConfig.APPLICATION_ID, Context.MODE_PRIVATE)
    }

    fun writeUserCredential(user: User?) {
        val json = if (user != null) Gson().toJson(UserCredential(user.name, user.user, user.userKey)) else null
        var edit = mPreference.edit()
        edit.putString(UserCredential.USER_CREDENTIAL, json)
        edit.commit()
    }

    fun readUserCredential(): UserCredential? {
        val json = mPreference.getString(UserCredential.USER_CREDENTIAL, null)
        return Gson().fromJson(json, UserCredential::class.java)
    }
}