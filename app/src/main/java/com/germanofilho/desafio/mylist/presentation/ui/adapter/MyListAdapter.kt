package com.germanofilho.desafio.mylist.presentation.ui.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.germanofilho.desafio.App
import com.germanofilho.desafio.R
import com.germanofilho.desafio.core.model.domain.entity.Movie
import com.germanofilho.desafio.core.model.domain.entity.MovieRealm
import com.germanofilho.desafio.core.util.MovieConverter
import com.germanofilho.desafio.movie.presentation.ui.activity.MovieDetailActivity
import com.squareup.picasso.Picasso
import io.realm.RealmList
import io.realm.RealmResults
import kotlinx.android.synthetic.main.adapter_movie.view.*

class MyListAdapter(val context: Context, private val movies: RealmList<MovieRealm>) :
        RecyclerView.Adapter<MyListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_movie, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindMovie(movies[position]!!)
    }

    override fun getItemCount() = movies.size

    inner class ViewHolder(private val containerView: View/*, private val itemClick: Movie*/)
        : RecyclerView.ViewHolder(containerView) {

        fun bindMovie(movie: MovieRealm) {
                Picasso.get().load(movie.thumbUrl).placeholder(R.drawable.placeholder).into(containerView.img_movie_thumb)
            containerView.img_movie_thumb.setOnClickListener(onItemClickListener(movie))
            }
        }


    private fun onItemClickListener(movie: MovieRealm): View.OnClickListener {
        return View.OnClickListener {
            context.startActivity(
                    MovieDetailActivity.newInstance(context, MovieConverter.fromRealm(movie))
            )
        }
    }
}
