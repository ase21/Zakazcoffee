package ru.zakazcoffee.shop.data.models

import com.google.gson.annotations.SerializedName

data class User(
        @SerializedName("name") val name: String,
        @SerializedName("email") val email: String,
        @SerializedName("phone") val phone: String,
        @SerializedName("adress") val address: String,
        @SerializedName("photo") val photo: String
)