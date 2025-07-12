package com.app.nukertrash.data.model.response


import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("data")
    var data: Data?,
    @SerializedName("message")
    var message: String?
)