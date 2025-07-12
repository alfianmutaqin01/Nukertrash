package com.app.nukertrash.data.model.response


import com.google.gson.annotations.SerializedName

data class ProfileResponse(
    @SerializedName("data")
    var `data`: DataXX?,
    @SerializedName("message")
    var message: Any?,
    @SerializedName("success")
    var success: Boolean?
)