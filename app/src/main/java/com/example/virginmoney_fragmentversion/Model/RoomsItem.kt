package com.example.virginmoney_fragmentversion.Model


import com.google.gson.annotations.SerializedName

data class RoomsItem(
    @SerializedName("createdAt")
    val createdAt: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("isOccupied")
    val isOccupied: Boolean,
    @SerializedName("maxOccupancy")
    val maxOccupancy: Int
)