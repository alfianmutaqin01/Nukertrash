package com.app.nukertrash.data.model.response


import com.google.gson.annotations.SerializedName

data class UpdateJenisSampahResponse(
    @SerializedName("data")
    var data: DataXXXXXXX?,
    @SerializedName("message")
    var message: String?,
    @SerializedName("success")
    var success: Boolean?
)