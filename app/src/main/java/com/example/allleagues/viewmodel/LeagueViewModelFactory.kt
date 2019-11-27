package com.example.allleagues.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.allleagues.data.repository.LeagueRepositoryImpl

class LeagueViewModelFactory constructor(private val leagueRepository: LeagueRepositoryImpl): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return LeagueViewModel(leagueRepository) as T
    }


}
