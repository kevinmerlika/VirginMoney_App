package com.example.virginmoney_fragmentversion.Model


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("body")
    val body: String,
    @SerializedName("fromId")
    val fromId: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("meetingid")
    val meetingId: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("toId")
    val toId: String
)