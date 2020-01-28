package com.example.mymechanic

class UserProfileData{
    private lateinit var userName:String
    private lateinit var userAge:String


    fun getName():String{
        return userName
    }
    fun getAge():String{
        return userAge
    }
    fun setName(str:String){
        userName  = str
    }
    fun setAge(str:String){
        userAge = str
    }


}