package com.app.nukertrash.data.model.response


import com.google.gson.annotations.SerializedName

data class DataXX(
    @SerializedName("balance")
    var balance: Int?,
    @SerializedName("bank")
    var bank: Any?,
    @SerializedName("bank_id")
    var bankId: Any?,
    @SerializedName("birth_date")
    var birthDate: Any?,
    @SerializedName("cc_number")
    var ccNumber: Any?,
    @SerializedName("created_at")
    var createdAt: String?,
    @SerializedName("email")
    var email: String?,
    @SerializedName("full_name")
    var fullName: Any?,
    @SerializedName("id")
    var id: String?,
    @SerializedName("phone_number")
    var phoneNumber: Any?,
    @SerializedName("role")
    var role: String?,
    @SerializedName("rt")
    var rt: Any?,
    @SerializedName("updated_at")
    var updatedAt: String?,
    @SerializedName("username")
    var username: String?
)