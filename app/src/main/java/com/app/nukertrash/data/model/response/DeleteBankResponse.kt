package com.app.nukertrash.data.model.response


import com.google.gson.annotations.SerializedName

data class DeleteBankResponse(
    @SerializedName("data")
    var data: Any?,
    @SerializedName("message")
    var message: String?,
    @SerializedName("success")
    var success: Boolean?
)