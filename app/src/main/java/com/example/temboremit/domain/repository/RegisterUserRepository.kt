package com.example.temboremit.domain.repository

import com.example.temboremit.data.Network.LoginUser
import com.example.temboremit.data.Network.RegisterUser
import com.example.temboremit.domain.models.LoginResponse
import com.example.temboremit.domain.models.RegisterResponse
import com.example.temboremit.domain.models.Users
import javax.inject.Inject

class RegisterUserRepository @Inject constructor(private val registerUser: RegisterUser) {
    suspend fun registerUser(username: String,email: String, password:String) : RegisterResponse {
        val registerRequest = Users(username,email, password)
        val response = registerUser.register(registerRequest)
        if (response.isSuccessful){
            return response.body() ?: throw Exception("Response body is null")
        }else{
            throw Exception("Failed checkin viewmodel: ${response.raw()}")
        }
    }
}



