package com.example.allleagues.ui

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.allleagues.data.League
import kotlinx.android.synthetic.main.view_holder_leagues.view.*

class LeagueViewHolder(item: View) : RecyclerView.ViewHolder(item) {

fun bindItem(league: League){
    itemView.tvLeagueName.text = league.strLeague
}

}
