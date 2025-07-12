package com.app.nukertrash.data.model.response


import com.google.gson.annotations.SerializedName

data class JenisSampahResponse(
    @SerializedName("data")
    var data: List<DataXXXX>?,
    @SerializedName("message")
    var message: Any?,
    @SerializedName("success")
    var success: Boolean?
)