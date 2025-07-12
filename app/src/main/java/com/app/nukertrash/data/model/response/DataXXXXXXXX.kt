package com.app.nukertrash.data.model.response


import com.google.gson.annotations.SerializedName

data class DataXXXXXXXX(
    @SerializedName("created_at")
    var createdAt: String?,
    @SerializedName("id")
    var id: String?,
    @SerializedName("name")
    var name: String?,
    @SerializedName("updated_at")
    var updatedAt: String?
)