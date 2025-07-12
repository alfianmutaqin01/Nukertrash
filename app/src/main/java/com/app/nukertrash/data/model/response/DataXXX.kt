package com.app.nukertrash.data.model.response


import com.google.gson.annotations.SerializedName

data class DataXXX(
    @SerializedName("balance")
    var balance: Int?,
    @SerializedName("bank_id")
    var bankId: String?,
    @SerializedName("birth_date")
    var birthDate: String?,
    @SerializedName("cc_number")
    var ccNumber: Long?,
    @SerializedName("created_at")
    var createdAt: String?,
    @SerializedName("email")
    var email: String?,
    @SerializedName("full_name")
    var fullName: String?,
    @SerializedName("id")
    var id: String?,
    @SerializedName("phone_number")
    var phoneNumber: Long?,
    @SerializedName("role")
    var role: String?,
    @SerializedName("rt")
    var rt: Int?,
    @SerializedName("updated_at")
    var updatedAt: String?,
    @SerializedName("username")
    var username: String?
)