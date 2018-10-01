package com.germanofilho.desafio.movie.presentation.ui.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.germanofilho.desafio.App
import com.germanofilho.desafio.R
import com.germanofilho.desafio.core.model.domain.entity.Movie
import com.germanofilho.desafio.core.view.ui.activity.BaseActivity
import com.germanofilho.desafio.movie.di.MovieModule
import com.germanofilho.desafio.movie.presentation.presenter.MoviePresenter
import com.germanofilho.desafio.movie.presentation.ui.MovieView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_movie_detail.*
import kotlinx.android.synthetic.main.toolbar_translucent.*
import javax.inject.Inject

class MovieDetailActivity : BaseActivity<MoviePresenter.Detail>(), MovieView.Detail {

    @Inject lateinit var mPresenter : MoviePresenter.Detail
    private lateinit var mMovie : Movie

    companion object {
        fun newInstance(context: Context, movie: Movie): Intent {
            val intent = Intent(context, MovieDetailActivity::class.java)
            intent.putExtra(context.getString(R.string.param_movie), movie)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        App.get(this)
                .getAppComponent()
                .plus(MovieModule(this))
                .inject(this)

        isTablet()

        mMovie = intent.getParcelableExtra(getString(R.string.param_movie))

        loadMovieData()
    }

    override fun onStart() {
        super.onStart()
        mPresenter.checkFavoriteMovie(mMovie)
    }

    override fun showSavedWithSuccess() {
        Toast.makeText(applicationContext, getString(R.string.saved), Toast.LENGTH_LONG).show()
    }

    override fun showRemovedWithSucess() {
        Toast.makeText(applicationContext, getString(R.string.removed), Toast.LENGTH_LONG).show()
    }

    override fun loadMovieData() {
        textview_title_about_movie.text = mMovie.title
        textview_original_name_content.text = mMovie.originalTitle
        textview_duration_content.text = getString(R.string.duration_time, mMovie.duration)
        textview_synopsis_content.text = mMovie.synopsis
        Picasso.get().load(mMovie.posterUrl).into(imageview_movie)
    }

    override fun changeTextFavorite(boolean: Boolean) {
        if(boolean) textview_favorite.text = getString(R.string.add_my_list)
        else textview_favorite.text = getString(R.string.remove_my_list)
    }

    override fun changeFavoriteOnClickAction(boolean: Boolean){
        if(boolean) textview_favorite.setOnClickListener { mPresenter.saveMovieToMyList(mMovie) }
        else textview_favorite.setOnClickListener { mPresenter.removeMovieFromMyList(mMovie) }
    }

    override fun showError() {
        Toast.makeText(applicationContext, getString(R.string.generic_error), Toast.LENGTH_LONG).show()
    }
}
