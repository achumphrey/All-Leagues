package com.example.allleagues.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.allleagues.data.League
import com.example.allleagues.data.repository.LeagueRepositoryImpl
import io.reactivex.disposables.CompositeDisposable

class LeagueViewModel constructor(private val repository: LeagueRepositoryImpl): ViewModel() {

    var leagueLiveData: MutableLiveData<List<League>> = MutableLiveData()
    var loadingState: MutableLiveData<String> = MutableLiveData()
    private val disposable = CompositeDisposable()

    fun getLeagues(){
        disposable.add(
            repository.getLeagues()
                .subscribe({
                    leagueLiveData.value = it.leagues
                }, {
                        loadingState.value = "Something went wrong"
                })
        )
    }

    override fun onCleared(){
        disposable.dispose()
        super.onCleared()
    }




}
