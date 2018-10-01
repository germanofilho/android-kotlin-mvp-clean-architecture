package com.germanofilho.desafio.account.presentation.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.germanofilho.desafio.App
import com.germanofilho.desafio.R
import com.germanofilho.desafio.account.di.AccountModule
import com.germanofilho.desafio.account.presentation.presenter.AccountPresenter
import com.germanofilho.desafio.account.presentation.ui.AccountView
import com.germanofilho.desafio.core.model.manager.SharedPreferenceManager
import com.germanofilho.desafio.core.view.ui.fragment.BaseFragment
import com.germanofilho.desafio.login.presentation.ui.activity.LoginActivity
import kotlinx.android.synthetic.main.fragment_account.*

class AccountFragment : BaseFragment<AccountPresenter>(), AccountView.Fragment {

    companion object {
        val TAG = AccountFragment::class.java.simpleName
        fun newInstance(): AccountFragment = AccountFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        App.get(context!!)
                .getAppComponent()
                .plus(AccountModule(this))
                .inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_account, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        txt_hello_user.text = getString(R.string.hello_user, SharedPreferenceManager.readUserCredential()?.userName)

    }

    override fun onStart() {
        super.onStart()
        btn_logout.setOnClickListener { basePresenter.logoutUser() }
    }

    override fun showError() {
        Toast.makeText(activity, "error", Toast.LENGTH_LONG).show()
    }


    override fun showLogoutWithSuccess() {
        Toast.makeText(activity, "Logout com sucesso!", Toast.LENGTH_LONG).show()
    }

    override fun goToLoginActivity() {
        startActivity(Intent(activity, LoginActivity::class.java))
    }


}