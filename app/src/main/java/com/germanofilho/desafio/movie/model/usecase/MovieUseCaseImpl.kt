package com.germanofilho.desafio.movie.model.usecase

import android.util.Log
import com.germanofilho.desafio.App
import com.germanofilho.desafio.core.model.domain.entity.Movie
import com.germanofilho.desafio.core.model.domain.entity.MovieRealm
import com.germanofilho.desafio.core.model.domain.entity.User
import com.germanofilho.desafio.core.model.manager.SharedPreferenceManager
import com.germanofilho.desafio.core.model.usecase.BaseUseCaseImpl
import com.germanofilho.desafio.movie.model.service.MovieService
import io.reactivex.Observable
import io.realm.Realm
import io.realm.RealmList
import io.realm.RealmQuery
import io.realm.kotlin.createObject
import javax.inject.Inject

class MovieUseCaseImpl @Inject constructor(private var service : MovieService) : BaseUseCaseImpl(service), MovieUseCase{

    private var mRealm : Realm

    init {
        Realm.init(App.instance)
        mRealm = Realm.getDefaultInstance()
    }

    override fun getMovieList(): Observable<List<Movie>> = execute(service.getMovieList())

    override fun saveMyList(movie: Movie) : Boolean {
        val mUser = getUser()
        if(!checkIfExistsOnMyList(movie)) {
            mRealm.executeTransaction {
                val mMovie = mRealm.createObject<MovieRealm>()
                mMovie.title = movie.title
                mMovie.originalTitle = movie.originalTitle
                mMovie.duration = movie.duration
                mMovie.synopsis = movie.synopsis
                mMovie.thumbUrl = movie.thumbUrl
                mMovie.posterUrl = movie.posterUrl

                if(mUser.movies == null){
                    mUser.movies = RealmList()
                }
                mUser.movies!!.add(mMovie)
            }
            return true
        }
        return false
    }

    override fun removeFromMyList(movie: Movie): Boolean {
        val mUser = getUser()

        try{
            mRealm.executeTransaction {
                val list = mUser.movies!!.filter { movieRealm -> movieRealm.title == movie.title }
                if(list.isNotEmpty()) {
                    mUser.movies!!.remove(list[0])
                }
            }
            return true
        } catch (e : Exception){
            Log.e("Remove", e.message)
            return false
        }
    }

    override fun checkIfExistsOnMyList(movie: Movie) : Boolean{
        return !getUser().movies!!.none { movieRealm -> movieRealm.title == movie.title}
    }


    private fun getUser() : User{
        return mRealm.where(User::class.java).contains("userKey", SharedPreferenceManager.readUserCredential()!!.userKey).findFirst()!!
    }


}
