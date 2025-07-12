package com.app.nukertrash.data.model.request


import com.google.gson.annotations.SerializedName

data class TambahBankRequest(
    @SerializedName("name")
    var name: String?
)