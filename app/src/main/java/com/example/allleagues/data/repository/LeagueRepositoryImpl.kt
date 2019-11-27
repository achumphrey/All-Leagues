package com.example.allleagues.data.repository

import com.example.allleagues.data.AllLeagues
import com.example.allleagues.data.remote.Webservices
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class LeagueRepositoryImpl @Inject constructor(private val webservices: Webservices) : LeagueRepository{
    override fun getLeagues(): Single<AllLeagues> {
      return  webservices.fetchLeagues()
          .subscribeOn(Schedulers.io())
          .observeOn(AndroidSchedulers.mainThread())
    }
}
