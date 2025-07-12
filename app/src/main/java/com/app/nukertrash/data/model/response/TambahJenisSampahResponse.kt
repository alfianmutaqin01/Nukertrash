package com.app.nukertrash.data.model.response


import com.google.gson.annotations.SerializedName

data class TambahJenisSampahResponse(
    @SerializedName("data")
    var data: DataXXXXXX?,
    @SerializedName("message")
    var message: String?,
    @SerializedName("success")
    var success: Boolean?
)