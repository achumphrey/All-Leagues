package com.example.allleagues.data.remote

import com.example.allleagues.data.AllLeagues
import com.example.allleagues.utils.Constants
import io.reactivex.Single
import retrofit2.http.GET

interface Webservices {

    @GET(Constants.ENDPOINT_URL)
    fun fetchLeagues(): Single<AllLeagues>
}