package com.example.temboremit.domain.models

data class Users(
    val username: String?,
    val email : String,
    val password : String

)


data class  LoginResponse(
    val status : Boolean,
    val message : String,
    val token : String
)

data class  RegisterResponse(
    val message : String,
)

data class UserLogin(
    val email : String,
    val password : String
)

