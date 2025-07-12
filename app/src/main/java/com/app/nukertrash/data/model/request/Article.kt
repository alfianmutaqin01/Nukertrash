package com.app.nukertrash.data.model.request

import com.google.gson.annotations.SerializedName

data class Article(
    @SerializedName("title")
    var title: String?,
    @SerializedName("content")
    var content: String?,
    @SerializedName("date")
    var date: String?


)
