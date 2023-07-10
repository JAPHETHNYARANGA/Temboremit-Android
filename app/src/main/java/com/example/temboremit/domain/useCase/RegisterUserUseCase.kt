package com.example.temboremit.domain.useCase

import android.util.Log
import com.example.temboremit.domain.models.RegisterResponse
import com.example.temboremit.domain.repository.RegisterUserRepository
import javax.inject.Inject

class RegisterUserUseCase @Inject constructor(private val registerUserRepository: RegisterUserRepository) {
    suspend fun registerUser(
        username:String,
        email:String,
        password:String
    ):RegisterResponse{
        try{
            return registerUserRepository.registerUser(username, email, password)
        }catch (e: Exception){

            Log.d("useCase Error", "${e.message}")
            throw e
        }
    }
}