package com.germanofilho.desafio.main.presentation.ui.activity

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import com.germanofilho.desafio.R
import com.germanofilho.desafio.account.presentation.ui.fragment.AccountFragment
import com.germanofilho.desafio.core.view.ui.activity.BaseActivity
import com.germanofilho.desafio.main.presentation.presenter.MainPresenter
import com.germanofilho.desafio.main.presentation.ui.MainView
import com.germanofilho.desafio.movie.presentation.ui.fragment.MovieListFragment
import com.germanofilho.desafio.mylist.presentation.ui.fragment.MyListFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<MainPresenter>(), MainView.Activity{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        isTablet()

        bottom_navigation.setOnNavigationItemSelectedListener(onBottomNavigationViewItemSelectedListener())
        // Starting tab bottom bar selected the profile section
        bottom_navigation.selectedItemId = R.id.navigation_movie_list
    }


    private fun onBottomNavigationViewItemSelectedListener(): BottomNavigationView.OnNavigationItemSelectedListener {
        return BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_movie_list -> {
                    addMovieListFragment()
                    true
                }
                R.id.navigation_my_list -> {
                    addMyListFragment()
                    true
                }
                R.id.navigation_account -> {
                    addAccountFragment()
                    true
                }

                else -> true
            }
        }
    }

    private fun setContentLayout(fragment: Fragment, tag: String) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(
                R.id.content,
                fragment,
                tag
        )

        fragmentTransaction
                .commit()
    }

    private fun addMovieListFragment(){
        var fragment = MovieListFragment.newInstance()
        setContentLayout(fragment, MovieListFragment.TAG)
    }

    private fun addMyListFragment(){
        var fragment = MyListFragment.newInstance()
        setContentLayout(fragment, MyListFragment.TAG)
    }

    private fun addAccountFragment(){
        var fragment = AccountFragment.newInstance()
        setContentLayout(fragment, AccountFragment.TAG)
    }
}
