package com.app.nukertrash.data.model.request

import com.google.gson.annotations.SerializedName

data class DaftarPickup(
    @SerializedName("nama")
    var nama: String?,
    @SerializedName("rt")
    var rt: String?,
    @SerializedName("rw")
    var rw: String?,

)
