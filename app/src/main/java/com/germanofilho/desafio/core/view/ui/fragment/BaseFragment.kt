package com.germanofilho.desafio.core.view.ui.fragment

import android.support.v4.app.Fragment
import android.view.View
import android.widget.ProgressBar
import com.germanofilho.desafio.R
import com.germanofilho.desafio.core.presenter.BasePresenter
import com.germanofilho.desafio.core.util.AppRoute
import com.germanofilho.desafio.core.view.ui.BaseView
import javax.inject.Inject

abstract class BaseFragment<V : BasePresenter> : Fragment(), BaseView {

    @Inject
    protected lateinit var basePresenter: V

    override fun gotToMainActivity() {
        AppRoute.goToMainActivity(activity!!)
    }

    override fun goToLoginActivity() {
        AppRoute.goToLoginActivity(activity!!)
    }

    override fun isToShowProgressBar(value: Boolean) {
        val progress = activity?.findViewById<ProgressBar>(R.id.progress_bar)
        if(value){
            progress?.visibility = View.VISIBLE
        } else {
            progress?.visibility = View.INVISIBLE
        }
    }

    override fun onStop() {
        basePresenter.onStop()
        isToShowProgressBar(false)
        super.onStop()
    }

}