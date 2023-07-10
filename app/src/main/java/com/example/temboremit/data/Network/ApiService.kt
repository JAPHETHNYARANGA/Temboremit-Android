package com.example.temboremit.data.Network

import com.example.temboremit.domain.models.LoginResponse
import com.example.temboremit.domain.models.RegisterResponse
import com.example.temboremit.domain.models.UserLogin
import com.example.temboremit.domain.models.Users
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface RegisterUser {
    @POST("register")
    suspend fun register(@Body Users : Users): Response<RegisterResponse>
}

interface LoginUser {
    @POST("login")
    suspend fun login(@Body UserLogin : UserLogin): Response<LoginResponse>
}