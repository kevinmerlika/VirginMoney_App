package com.example.virginmoney_fragmentversion.Repository

import com.example.virginmoney_fragmentversion.Network.Api
import javax.inject.Inject

class ApiRepository
@Inject
constructor(private val api: Api)  {
    suspend fun getAllPeople() = api.getPeople()
    suspend fun getAllRooms() = api.getRooms()
}