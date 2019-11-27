package com.example.allleagues

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.allleagues.di.DaggerLeagueComponent
import com.example.allleagues.di.LeagueRepositoryModule
import com.example.allleagues.di.LeagueWebservicesModule
import com.example.allleagues.ui.LeagueAdapter
import com.example.allleagues.viewmodel.LeagueViewModel
import com.example.allleagues.viewmodel.LeagueViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class LeaguesMainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: LeagueViewModelFactory
    lateinit var viewModel: LeagueViewModel
    lateinit var leagueAdapter: LeagueAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getDepenedency()
        setRecyclerview()

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(LeagueViewModel::class.java)

        viewModel.leagueLiveData.observe(this, Observer {
            leagueAdapter.league.clear()
            leagueAdapter.league.addAll(it)
            leagueAdapter.notifyDataSetChanged()
        })

        viewModel.getLeagues()
    }

    fun getDepenedency(){
        DaggerLeagueComponent.builder()
            .leagueWebservicesModule(LeagueWebservicesModule())
            .leagueRepositoryModule(LeagueRepositoryModule())
            .build()
            .inject(this)
    }

    fun setRecyclerview(){
        leagueAdapter = LeagueAdapter(mutableListOf())
        rvLeague.layoutManager = LinearLayoutManager(this)
        rvLeague.adapter = leagueAdapter
    }
}
