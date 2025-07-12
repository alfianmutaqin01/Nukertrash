package com.app.nukertrash.data.model.response


import com.google.gson.annotations.SerializedName

data class DetailBankResponse(
    @SerializedName("data")
    var data: DataXXXXXXXXX?,
    @SerializedName("message")
    var message: Any?,
    @SerializedName("success")
    var success: Boolean?
)