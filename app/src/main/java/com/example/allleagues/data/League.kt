package com.example.allleagues.data


import com.google.gson.annotations.SerializedName

data class League(
    @SerializedName("idLeague")
    val idLeague: String,
    @SerializedName("strLeague")
    val strLeague: String,
    @SerializedName("strLeagueAlternate")
    val strLeagueAlternate: String,
    @SerializedName("strSport")
    val strSport: String
)