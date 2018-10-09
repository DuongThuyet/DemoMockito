package com.example.duongnguyen.demomoc

import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


import org.mockito.Mockito
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

class GreeterTest {

    var user = mock(User::class.java)

    var teste = mock(Greeter::class.java)

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        teste = Greeter(user)
    }

    @Test
    fun englishGreetIsCorrect() {
        Mockito.`when`(user.fullName()).thenReturn("Fábio Carballo")
        assertEquals("Hello, Fábio Carballo!", teste.getEnglishGreeting())
    }


}