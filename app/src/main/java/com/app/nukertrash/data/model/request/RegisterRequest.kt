package com.app.nukertrash.data.model.request


import com.google.gson.annotations.SerializedName

data class RegisterRequest(
    @SerializedName("email")
    var email: String?,
    @SerializedName("password")
    var password: String?,
    @SerializedName("password_confirmation")
    var passwordConfirmation: String?,
    @SerializedName("username")
    var username: String?
)