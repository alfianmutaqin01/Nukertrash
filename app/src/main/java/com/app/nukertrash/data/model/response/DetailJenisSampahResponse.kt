package com.app.nukertrash.data.model.response


import com.google.gson.annotations.SerializedName

data class DetailJenisSampahResponse(
    @SerializedName("data")
    var data: DataXXXXX?,
    @SerializedName("message")
    var message: Any?,
    @SerializedName("success")
    var success: Boolean?
)