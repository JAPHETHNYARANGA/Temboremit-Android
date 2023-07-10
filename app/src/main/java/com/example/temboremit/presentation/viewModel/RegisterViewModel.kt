package com.example.temboremit.presentation.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.temboremit.domain.models.LoginResponse
import com.example.temboremit.domain.models.RegisterResponse
import com.example.temboremit.domain.useCase.LoginUserUseCase
import com.example.temboremit.domain.useCase.RegisterUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import java.net.SocketTimeoutException
import javax.inject.Inject


@HiltViewModel
class RegisterViewModel @Inject constructor(private val registerUserUseCase: RegisterUserUseCase) : ViewModel() {
    private val _registerUser = MutableLiveData<RegisterResponse>()
    val registerUser : LiveData<RegisterResponse> get() = _registerUser

    private val _registerSuccess = MutableLiveData<Boolean>()
    val registerSuccess : LiveData<Boolean> get() = _registerSuccess

    suspend fun registerUser(
        username : String,
        email:String,
        password :String
    ): RegisterResponse{
        try {
            return registerUserUseCase.registerUser(username, email, password)
        }catch (e: SocketTimeoutException){
            Log.d("exception", "Timeout Exception")
            throw RegisterException("Request timed out")
        }
    }
}


class RegisterException(message: String) : Exception(message)

