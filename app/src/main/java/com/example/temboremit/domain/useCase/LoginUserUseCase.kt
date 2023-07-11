package com.example.temboremit.domain.useCase

import android.util.Log
import com.example.temboremit.domain.models.LoginResponse
import com.example.temboremit.domain.repository.LoginUserRepository
import javax.inject.Inject

class LoginUserUseCase @Inject constructor(private val loginUserRepository: LoginUserRepository) {
    suspend fun loginUser(
        email:String,
        password:String
    ):LoginResponse{
        try {
            return loginUserRepository.loginUser( email, password)

        }catch (e: Exception){

            Log.d("useCase Error", "${e.message}")
            throw e
        }
    }
}