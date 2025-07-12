package com.app.nukertrash.data.model.response


import com.google.gson.annotations.SerializedName

data class GetBankResponse(
    @SerializedName("data")
    var data: List<DataXXXXXXXX>?,
    @SerializedName("message")
    var message: Any?,
    @SerializedName("success")
    var success: Boolean?
)