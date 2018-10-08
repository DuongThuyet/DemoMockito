package com.example.duongnguyen.demomoc

 class User(private val firstName: String, private val lastName: String) {
    fun fullName(): String = "$firstName $lastName"
}