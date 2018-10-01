package com.germanofilho.desafio.core.view.ui.activity

import android.content.pm.ActivityInfo
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import android.view.View
import com.germanofilho.desafio.core.presenter.BasePresenter
import com.germanofilho.desafio.core.util.AppRoute
import com.germanofilho.desafio.core.util.ScreenUtil
import com.germanofilho.desafio.core.view.ui.BaseView
import kotlinx.android.synthetic.main.layout_progress_bar.*
import javax.inject.Inject

abstract class BaseActivity<V : BasePresenter> : AppCompatActivity(), BaseView.Activity{

    @Inject
    lateinit var basePresenter: V

    override fun gotToMainActivity() {
        AppRoute.goToMainActivity(this)
    }

    override fun goToLoginActivity() {
        AppRoute.goToLoginActivity(this)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId){
            android.R.id.home -> onBackPressed()
        }
        return true
    }

    override fun isToShowProgressBar(value: Boolean) {
        if (value) {
            progress_bar?.visibility = View.VISIBLE
        } else {
            progress_bar?.visibility = View.GONE
        }
    }

    override fun isTablet() {
        if(ScreenUtil.isTabletDevice(this)) requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE
    }
}