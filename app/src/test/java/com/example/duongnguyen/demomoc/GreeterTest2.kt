package com.example.duongnguyen.demomoc

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class GreeterTest2 {
    //Field user of type User - was not mocked since Mockito doesn't mock a Final class when 'mock-maker-inline' option is not set
    private var greeter = Greeter(User("firstName", "lastName"))

    @Test
    fun testGetEnglishGreeting() {
        val result = greeter.getEnglishGreeting()
        Assertions.assertEquals("replaceMeWithExpectedResult", result)
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme