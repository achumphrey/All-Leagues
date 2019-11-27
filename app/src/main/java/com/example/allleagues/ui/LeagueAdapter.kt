package com.example.allleagues.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.allleagues.R
import com.example.allleagues.data.League

class LeagueAdapter constructor(var league: MutableList<League>):
    RecyclerView.Adapter<LeagueViewHolder>()  {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LeagueViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.view_holder_leagues, parent, false)
        return LeagueViewHolder(view)
    }

    override fun getItemCount(): Int {
        return league.size
    }

    override fun onBindViewHolder(holder: LeagueViewHolder, position: Int) {
        holder.bindItem(league[position])
    }
}