package com.germanofilho.desafio.splash.presentation.ui.activity

import android.content.Intent
import android.content.pm.ActivityInfo
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.germanofilho.desafio.R
import com.germanofilho.desafio.core.util.ScreenUtil
import com.germanofilho.desafio.core.util.ScreenUtil.Companion.isTabletDevice
import com.germanofilho.desafio.login.presentation.ui.activity.LoginActivity
import io.reactivex.Completable
import java.util.concurrent.TimeUnit

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        if(isTabletDevice(this)) if(ScreenUtil.isTabletDevice(this)) requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE

        Completable.complete()
                .delay(2, TimeUnit.SECONDS)
                .doOnComplete{
                    startActivity(Intent(this, LoginActivity::class.java))
                    finishAffinity()
                }
                .subscribe()
        }
}
