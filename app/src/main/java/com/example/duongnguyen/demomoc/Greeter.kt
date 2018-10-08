package com.example.duongnguyen.demomoc

 class Greeter(private val user: User) {
    fun getEnglishGreeting() = "Hello, ${user.fullName()}!"
}