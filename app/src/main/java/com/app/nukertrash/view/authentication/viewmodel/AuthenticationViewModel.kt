package com.app.nukertrash.view.authentication.viewmodel

import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.app.nukertrash.data.model.request.LoginRequest
import com.app.nukertrash.data.model.request.RegisterRequest
import com.app.nukertrash.data.model.response.LoginResponse
import com.app.nukertrash.data.model.response.RegisterResponse
import com.app.nukertrash.data.network.ApiClient

class AuthenticationViewModel : ViewModel() {
    private val login = MutableLiveData<LoginResponse?>()
    private val register = MutableLiveData<RegisterResponse?>()

    fun login() : MutableLiveData<LoginResponse?> {
        return login
    }

    fun register() : MutableLiveData<RegisterResponse?> {
        return register
    }

    fun loginUser(request : LoginRequest) {
        ApiClient.instance.login(request).enqueue(object : Callback<LoginResponse> {
            override fun onResponse(call : Call<LoginResponse>, response : Response<LoginResponse>) {
                Log.d("Is Sucess", "onResponse: ${response.isSuccessful}")
                Log.d("Message", "onResponse: ${response.body()!!.data}")
                Log.d("Error Body", "onResponse: ${response.errorBody()?.string()}")
                if (response.isSuccessful) {
                    login.postValue(response.body())
                } else {
                    login.postValue(null)
                }
            }

            override fun onFailure(call : Call<LoginResponse>, t : Throwable) {
                login.postValue(null)
                Log.d("TAG", "onFailure: ${t.message}")
            }
        })
    }

    fun registerUser(request : RegisterRequest) {
        ApiClient.instance.register(request).enqueue(object : Callback<RegisterResponse> {
            override fun onResponse(call : Call<RegisterResponse>, response : Response<RegisterResponse>) {
                Log.d("Is Sucess", "onResponse: ${response.isSuccessful}")
                Log.d("Message", "onResponse: ${response.message()}")
                Log.d("Error Body", "onResponse: ${response.errorBody()?.string()}")
                if (response.isSuccessful) {
                    register.postValue(response.body())
                } else {
                    register.postValue(null)
                }
            }

            override fun onFailure(call : Call<RegisterResponse>, t : Throwable) {
                register.postValue(null)
                Log.d("TAG", "onFailure: ${t.message}")
            }
        })
    }
}