package com.app.nukertrash.data.model.response


import com.google.gson.annotations.SerializedName

data class DataXXXXXXX(
    @SerializedName("created_at")
    var createdAt: String?,
    @SerializedName("id")
    var id: String?,
    @SerializedName("name")
    var name: String?,
    @SerializedName("updated_at")
    var updatedAt: String?
)