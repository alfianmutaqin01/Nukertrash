package com.app.nukertrash.data.model.response


import com.google.gson.annotations.SerializedName

data class DataX(
    @SerializedName("created_at")
    var createdAt: String?,
    @SerializedName("email")
    var email: String?,
    @SerializedName("id")
    var id: String?,
    @SerializedName("updated_at")
    var updatedAt: String?,
    @SerializedName("username")
    var username: String?
)