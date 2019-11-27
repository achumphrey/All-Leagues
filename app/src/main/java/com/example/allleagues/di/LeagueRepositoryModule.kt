package com.example.allleagues.di

import com.example.allleagues.data.repository.LeagueRepositoryImpl
import com.example.allleagues.viewmodel.LeagueViewModel
import com.example.allleagues.viewmodel.LeagueViewModelFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LeagueRepositoryModule {

    @Singleton
    @Provides
    fun provideLeagueViemodelFactory(repositoryImpl: LeagueRepositoryImpl): LeagueViewModelFactory {
        return LeagueViewModelFactory(repositoryImpl)
    }
}