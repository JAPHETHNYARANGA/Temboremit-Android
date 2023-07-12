package com.example.temboremit.domain.models.maplerad

data class createTier1Customer(
    val status : Boolean,
    val message : String,
    val data : data
)


data class data(
    val id:String,
    val first_name: String,
    val last_name:String,
    val email:String,
    val country : String,
    val status : String,
    val tier : Int,
    val created_at : String,
    val updated_at : String
)
