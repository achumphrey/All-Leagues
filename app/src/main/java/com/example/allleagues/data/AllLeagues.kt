package com.example.allleagues.data


import com.google.gson.annotations.SerializedName

data class AllLeagues(
    @SerializedName("leagues")
    val leagues: List<League>
)