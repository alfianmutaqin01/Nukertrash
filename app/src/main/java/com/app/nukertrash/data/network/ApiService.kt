package com.app.nukertrash.data.network

import com.app.nukertrash.data.model.request.LoginRequest
import com.app.nukertrash.data.model.request.RegisterRequest
import com.app.nukertrash.data.model.request.TambahBankRequest
import com.app.nukertrash.data.model.request.TambahJenisSampahRequest
import com.app.nukertrash.data.model.request.UpdateBankRequest
import com.app.nukertrash.data.model.request.UpdateJenisSampahRequest
import com.app.nukertrash.data.model.request.UpdateProfileRequest
import com.app.nukertrash.data.model.response.DeleteBankResponse
import com.app.nukertrash.data.model.response.DeleteJenisSampahResponse
import com.app.nukertrash.data.model.response.DetailBankResponse
import com.app.nukertrash.data.model.response.DetailJenisSampahResponse
import com.app.nukertrash.data.model.response.GetBankResponse
import com.app.nukertrash.data.model.response.JenisSampahResponse
import com.app.nukertrash.data.model.response.LoginResponse
import com.app.nukertrash.data.model.response.ProfileResponse
import com.app.nukertrash.data.model.response.RegisterResponse
import com.app.nukertrash.data.model.response.TambahBankResponse
import com.app.nukertrash.data.model.response.TambahJenisSampahResponse
import com.app.nukertrash.data.model.response.UpdateBankResponse
import com.app.nukertrash.data.model.response.UpdateJenisSampahResponse
import com.app.nukertrash.data.model.response.UpdateProfileResponse
import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    @POST("login")
    fun login(@Body body: LoginRequest): Call<LoginResponse>

    @POST("register")
    fun register(@Body body: RegisterRequest): Call<RegisterResponse>

    // Get Profile
    @GET("profile")
    fun getUser(@Header("Authorization") token: String): Call<ProfileResponse>

    // Update Profile
    @POST("profile")
    fun updateUser(@Header("Authorization") token: String, @Body body: UpdateProfileRequest): Call<UpdateProfileResponse>

    @GET("banks")
    fun getBanks(@Header("Authorization") token: String): Call<GetBankResponse>

    @GET("banks/{id}")
    fun getBankById(@Header("Authorization") token: String, @Path("id") id: Int): Call<DetailBankResponse>

    @POST("banks")
    fun addBank(@Header("Authorization") token: String, @Body body: TambahBankRequest): Call<TambahBankResponse>

    @PUT("banks/{id}")
    fun updateBank(@Header("Authorization") token: String, @Path("id") id: Int, @Body body: UpdateBankRequest): Call<UpdateBankResponse>

    @DELETE("banks/{id}")
    fun deleteBank(@Header("Authorization") token: String, @Path("id") id: Int): Call<DeleteBankResponse>

    @GET("trash-type")
    fun getTrashType(@Header("Authorization") token: String): Call<JenisSampahResponse>

    @GET("trash-type/{id}")
    fun getTrashTypeById(@Header("Authorization") token: String, @Path("id") id: Int): Call<DetailJenisSampahResponse>

    @POST("trash-type")
    fun addTrashType(@Header("Authorization") token: String, @Body body: TambahJenisSampahRequest): Call<TambahJenisSampahResponse>

    @PUT("trash-type/{id}")
    fun updateTrashType(@Header("Authorization") token: String, @Path("id") id: Int, @Body body: UpdateJenisSampahRequest): Call<UpdateJenisSampahResponse>

    @DELETE("trash-type/{id}")
    fun deleteTrashType(@Header("Authorization") token: String, @Path("id") id: Int): Call<DeleteJenisSampahResponse>
}