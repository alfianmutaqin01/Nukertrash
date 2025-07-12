package com.app.nukertrash.view.profile.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.app.nukertrash.data.model.request.UpdateProfileRequest
import com.app.nukertrash.data.model.response.LoginResponse
import com.app.nukertrash.data.model.response.ProfileResponse
import com.app.nukertrash.data.model.response.UpdateProfileResponse
import com.app.nukertrash.data.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProfileViewModel : ViewModel() {
    private val profile = MutableLiveData<ProfileResponse?>()
    private val updateProfile = MutableLiveData<UpdateProfileResponse?>()


    fun profile() : MutableLiveData<ProfileResponse?> {
        return profile
    }

    fun updateProfile() : MutableLiveData<UpdateProfileResponse?> {
        return updateProfile
    }

    fun profileUser(token : String) {
        ApiClient.instance.getUser("Bearer $token").enqueue(object : Callback<ProfileResponse> {
            override fun onResponse(call : Call<ProfileResponse>, response : Response<ProfileResponse>) {
                Log.d("Is Sucess", "onResponse: ${response.isSuccessful}")
                Log.d("Message", "onResponse: ${response.body()!!.data}")
                Log.d("Error Body", "onResponse: ${response.errorBody()?.string()}")
                if (response.isSuccessful) {
                    profile.postValue(response.body())
                } else {
                    profile.postValue(null)
                }
            }

            override fun onFailure(call : Call<ProfileResponse>, t : Throwable) {
                profile.postValue(null)
                Log.d("TAG", "onFailure: ${t.message}")
            }
        })
    }

    fun profileUpdate(token : String ,request : UpdateProfileRequest){
        ApiClient.instance.updateUser("Bearer ${token}", request).enqueue(object : Callback<UpdateProfileResponse> {
            override fun onResponse(call : Call<UpdateProfileResponse>, response : Response<UpdateProfileResponse>) {
                Log.d("Is Sucess", "onResponse: ${response.isSuccessful}")
                Log.d("Message", "onResponse: ${response.message()}")
                Log.d("Error Body", "onResponse: ${response.errorBody()?.string()}")
                if (response.isSuccessful) {
                    updateProfile.postValue(response.body())
                } else {
                    updateProfile.postValue(null)
                }
            }

            override fun onFailure(call : Call<UpdateProfileResponse>, t : Throwable) {
                updateProfile.postValue(null)
                Log.d("TAG", "onFailure: ${t.message}")
            }
        })
    }
}