package com.example.allleagues.data.repository

import com.example.allleagues.data.AllLeagues
import io.reactivex.Single

interface LeagueRepository {
    fun getLeagues() : Single<AllLeagues>
}