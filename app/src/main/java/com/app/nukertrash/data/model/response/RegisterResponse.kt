package com.app.nukertrash.data.model.response


import com.google.gson.annotations.SerializedName

data class RegisterResponse(
    @SerializedName("data")
    var data: DataX?,
    @SerializedName("message")
    var message: Any?,
    @SerializedName("success")
    var success: Boolean?
)