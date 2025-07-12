package com.app.nukertrash.data.model.response


import com.google.gson.annotations.SerializedName

data class UpdateProfileResponse(
    @SerializedName("data")
    var data: DataXXX?,
    @SerializedName("message")
    var message: String?,
    @SerializedName("success")
    var success: Boolean?
)