package com.example.temboremit.domain.repository

import com.example.temboremit.data.Network.LoginUser
import com.example.temboremit.domain.models.LoginResponse
import com.example.temboremit.domain.models.UserLogin
import com.example.temboremit.domain.models.Users
import javax.inject.Inject

class LoginUserRepository @Inject constructor(private val loginUser: LoginUser) {
    suspend fun loginUser(email: String, password:String): LoginResponse{
        val loginRequest = UserLogin(email, password)
        val response = loginUser.login(loginRequest)
        if (response.isSuccessful){
            return response.body() ?: throw Exception("Response body is null")
        }else{
            throw Exception("Failed checkin viewmodel: ${response.raw()}")
        }
    }
}