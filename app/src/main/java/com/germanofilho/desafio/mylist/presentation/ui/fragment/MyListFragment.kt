package com.germanofilho.desafio.mylist.presentation.ui.fragment

import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.germanofilho.desafio.App
import com.germanofilho.desafio.R
import com.germanofilho.desafio.core.model.domain.entity.MovieRealm
import com.germanofilho.desafio.core.util.ScreenUtil
import com.germanofilho.desafio.core.view.ui.fragment.BaseFragment
import com.germanofilho.desafio.mylist.di.MyListModule
import com.germanofilho.desafio.mylist.presentation.presenter.MyListPresenter
import com.germanofilho.desafio.mylist.presentation.ui.MyListView
import com.germanofilho.desafio.mylist.presentation.ui.adapter.MyListAdapter
import io.realm.RealmList
import kotlinx.android.synthetic.main.fragment_movie_list.*
import javax.inject.Inject

class MyListFragment : BaseFragment<MyListPresenter>(), MyListView.Fragment {

    @Inject
    lateinit var mPresenter : MyListPresenter

    lateinit var mAdapter: MyListAdapter


    companion object {

        val TAG = MyListFragment::class.java.simpleName

        fun newInstance(): MyListFragment = MyListFragment()

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        App.get(context!!)
                .getAppComponent()
                .plus(MyListModule(this))
                .inject(this)

    }

    override fun onResume() {
        super.onResume()
        mPresenter.fetchMyList()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val layoutManager = GridLayoutManager(context,ScreenUtil.setValueIfTablet())
        recycler_view_movie_list.layoutManager = layoutManager
    }


    override fun loadRecyclerView(realmList: RealmList<MovieRealm>) {
        mAdapter = MyListAdapter(context!!, realmList)
        recycler_view_movie_list.adapter = mAdapter
    }

    override fun showEmptyListText(boolean: Boolean) {
        if(boolean) txt_empty_list.visibility = View.VISIBLE
        else txt_empty_list.visibility = View.GONE
    }
}