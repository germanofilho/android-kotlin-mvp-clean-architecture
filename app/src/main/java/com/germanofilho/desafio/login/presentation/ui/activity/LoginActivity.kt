package com.germanofilho.desafio.login.presentation.ui.activity

import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.content.ContextCompat
import android.view.inputmethod.EditorInfo
import com.germanofilho.desafio.App
import com.germanofilho.desafio.R
import com.germanofilho.desafio.core.util.ScreenUtil
import com.germanofilho.desafio.core.view.ui.activity.BaseActivity
import com.germanofilho.desafio.login.di.LoginModule
import com.germanofilho.desafio.login.presentation.presenter.LoginPresenter
import com.germanofilho.desafio.login.presentation.ui.LoginView
import com.germanofilho.desafio.signup.presentation.ui.activity.SignUpActivity
import kotlinx.android.synthetic.main.activity_login.*
import javax.inject.Inject

class LoginActivity : BaseActivity<LoginPresenter>(), LoginView.Activity{

    @Inject lateinit var mPresenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        App.get(this)
                .getAppComponent()
                .plus(LoginModule(this))
                .inject(this)

        isTablet()
    }


    override fun onResume() {
        super.onResume()
        mPresenter.checkAlreadyLogged()
    }

    override fun onStart() {
        super.onStart()
        btn_login.setOnClickListener { doLogin() }
        btn_sign_up.setOnClickListener { goToSignUpActivity() }

        edt_login_pass.setOnEditorActionListener { _, i, _ ->
            if(i == EditorInfo.IME_ACTION_DONE){
                mPresenter.fetchUserCredential(edt_login_user.text.toString(), edt_login_pass.text.toString())
                true
            } else {
                false
            }
        }
    }

    override fun doLogin() {
        mPresenter.fetchUserCredential(edt_login_user.text.toString(), edt_login_pass.text.toString())
    }


    override fun goToSignUpActivity() {
        startActivity(Intent(this, SignUpActivity::class.java))
    }

    override fun showLoginError() {
        val snackbar = Snackbar.make(content_login_activity, getString(R.string.error_login), Snackbar.LENGTH_SHORT)
        snackbar.view.setBackgroundColor(ContextCompat.getColor(this, R.color.colorAccent))
        snackbar.show()
    }
}
