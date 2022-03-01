package com.example.design_log.data.https.model

import com.google.gson.annotations.SerializedName

data class UserCreate(

    @SerializedName("display_name")
    val displayName: String,
    val email: String,
    val password: String
)
