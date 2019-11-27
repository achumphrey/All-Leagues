package com.example.allleagues.di

import com.example.allleagues.LeaguesMainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [LeagueWebservicesModule::class, LeagueRepositoryModule::class])
interface LeagueComponent {
    fun inject(leaguesMainActivity: LeaguesMainActivity)
}