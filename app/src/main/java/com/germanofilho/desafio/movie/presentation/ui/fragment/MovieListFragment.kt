package com.germanofilho.desafio.movie.presentation.ui.fragment

import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.germanofilho.desafio.App
import com.germanofilho.desafio.R
import com.germanofilho.desafio.core.model.domain.entity.Movie
import com.germanofilho.desafio.core.util.ScreenUtil
import com.germanofilho.desafio.core.view.ui.fragment.BaseFragment
import com.germanofilho.desafio.movie.di.MovieModule
import com.germanofilho.desafio.movie.presentation.presenter.MoviePresenter
import com.germanofilho.desafio.movie.presentation.ui.MovieView
import com.germanofilho.desafio.movie.presentation.ui.adapter.MovieAdapter
import kotlinx.android.synthetic.main.fragment_movie_list.*
import kotlinx.android.synthetic.main.fragment_movie_list.view.*
import javax.inject.Inject


class MovieListFragment : BaseFragment<MoviePresenter.MovieList>(), MovieView.MovieList {

    @Inject lateinit var mPresenter : MoviePresenter.MovieList

    lateinit var mAdapter: MovieAdapter

    companion object {

        val TAG = MovieListFragment::class.java.simpleName

        fun newInstance(): MovieListFragment = MovieListFragment()

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        App.get(context!!)
                .getAppComponent()
                .plus(MovieModule(this))
                .inject(this)

    }

    override fun onResume() {
        super.onResume()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val layoutManager = GridLayoutManager(context, ScreenUtil.setValueIfTablet())
        recycler_view_movie_list.layoutManager = layoutManager
        mPresenter.fetchMovieList()
    }

    override fun loadRecyclerView(movies: List<Movie>) {
        mAdapter = MovieAdapter(context!!, movies)
        recycler_view_movie_list.adapter = mAdapter
    }
}