package com.germanofilho.desafio.core.util

import android.app.Activity
import android.content.Intent
import android.support.v4.app.ActivityCompat
import com.germanofilho.desafio.login.presentation.ui.activity.LoginActivity
import com.germanofilho.desafio.main.presentation.ui.activity.MainActivity
import com.germanofilho.desafio.signup.presentation.ui.activity.SignUpActivity

object AppRoute {

    fun goToLoginActivity(activity: Activity){
        activity.startActivity(Intent(activity, LoginActivity::class.java))
        ActivityCompat.finishAffinity(activity)
    }

    fun goToSignUpActivity(activity: Activity){
        activity.startActivity(Intent(activity, SignUpActivity::class.java))
    }


    fun goToMainActivity(activity: Activity){
        activity.startActivity(Intent(activity, MainActivity::class.java))
        ActivityCompat.finishAffinity(activity)
    }
}