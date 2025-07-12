package com.app.nukertrash.data.model.request


import com.google.gson.annotations.SerializedName

data class UpdateProfileRequest(
    @SerializedName("bank_id")
    var bankId: String?,
    @SerializedName("birth_date")
    var birthDate: String?,
    @SerializedName("cc_number")
    var ccNumber: Long?,
    @SerializedName("email")
    var email: String?,
    @SerializedName("full_name")
    var fullName: String?,
    @SerializedName("password")
    var password: String?,
    @SerializedName("password_confirmation")
    var passwordConfirmation: String?,
    @SerializedName("phone_number")
    var phoneNumber: Long?,
    @SerializedName("rt")
    var rt: Int?,
    @SerializedName("username")
    var username: String?
)