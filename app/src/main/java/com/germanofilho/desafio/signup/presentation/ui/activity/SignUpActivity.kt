package com.germanofilho.desafio.signup.presentation.ui.activity

import android.content.Intent
import android.os.Bundle
import android.view.inputmethod.EditorInfo
import android.widget.Toast
import com.germanofilho.desafio.App
import com.germanofilho.desafio.R
import com.germanofilho.desafio.core.model.domain.entity.User
import com.germanofilho.desafio.core.view.ui.activity.BaseActivity
import com.germanofilho.desafio.login.presentation.ui.activity.LoginActivity
import com.germanofilho.desafio.signup.di.SignUpModule
import com.germanofilho.desafio.signup.presentation.presenter.SignUpPresenter
import com.germanofilho.desafio.signup.presentation.ui.SignUpView
import kotlinx.android.synthetic.main.activity_sign_up.*
import kotlinx.android.synthetic.main.toolbar.*
import javax.inject.Inject

class SignUpActivity : BaseActivity<SignUpPresenter>(), SignUpView.Activity {

    @Inject lateinit var mPresenter : SignUpPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        App.get(this)
                .getAppComponent()
                .plus(SignUpModule(this))
                .inject(this)

        isTablet()
    }

    override fun onStart() {
        super.onStart()
        btn_sign_up_send.setOnClickListener { mPresenter.intentSaveUser(sendUserData()) }

        edt_sign_up_pass.setOnEditorActionListener { _, i, _ ->
            if(i == EditorInfo.IME_ACTION_DONE){
                mPresenter.intentSaveUser(sendUserData())
                true
            } else {
                false
            }
        }
    }


    private fun sendUserData() : User{
        return User(edt_sign_up_name.text.toString(), edt_sign_up_user.text.toString(), edt_sign_up_pass.text.toString(), "")
    }

    override fun goToLoginActivity() {
        startActivity(Intent(this, LoginActivity::class.java))
        finishAffinity()
    }

    override fun showSaveUserErro() {
        Toast.makeText(applicationContext, "Error", Toast.LENGTH_LONG).show()
    }
}
