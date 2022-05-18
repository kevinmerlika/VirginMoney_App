package com.example.virginmoney_fragmentversion.Network

import com.example.virginmoney_fragmentversion.Model.PeopleItem
import com.example.virginmoney_fragmentversion.Model.RoomsItem
import retrofit2.Response
import retrofit2.http.GET

interface Api {

    @GET("people")
    suspend fun getPeople(): Response<List<PeopleItem>>

    @GET("rooms")
    suspend fun getRooms(): Response<List<RoomsItem>>
}