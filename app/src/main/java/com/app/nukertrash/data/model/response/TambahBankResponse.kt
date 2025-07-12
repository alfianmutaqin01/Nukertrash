package com.app.nukertrash.data.model.response


import com.google.gson.annotations.SerializedName

data class TambahBankResponse(
    @SerializedName("data")
    var data: DataXXXXXXXXXX?,
    @SerializedName("message")
    var message: String?,
    @SerializedName("success")
    var success: Boolean?
)