package com.app.nukertrash.data.model.response


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("token")
    var token: String?,
    @SerializedName("user")
    var user: User?
)