package com.app.nukertrash.data.model.request

import com.google.gson.annotations.SerializedName

data class Sampah(
    @SerializedName("jenisSampah")
    var jenisSampah: String?,
    @SerializedName("harga")
    var harga: Int?
)
