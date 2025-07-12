package com.app.nukertrash.data.model.response


import com.google.gson.annotations.SerializedName

data class UpdateBankResponse(
    @SerializedName("data")
    var data: DataXXXXXXXXXXX?,
    @SerializedName("message")
    var message: String?,
    @SerializedName("success")
    var success: Boolean?
)