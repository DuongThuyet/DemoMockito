package com.example.duongnguyen.demomoc

import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.mock
import org.mockito.MockitoAnnotations


class TemperaturePresenterTest {

    private var locationProvider = mock(LocationProvider::class.java)

    private var temperatureProvider = mock(TemperatureProvider::class.java)

    private var view = mock(View::class.java)

    private var temperaturePresenter = TemperaturePresenter(locationProvider = locationProvider,
            temperatureProvider = temperatureProvider,
            view = view)

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun testInexactTemperatureIsDisplayedFollowedByExactTemperature() {
        val lastLocation = Coordinate(41.5, 8.9)
        
        val currentLocation = Coordinate(38.7, 9.7)

        Mockito.`when`(locationProvider.getExactLocation()).thenReturn(currentLocation)

        Mockito.`when`(locationProvider.getLastKnownLocation()).thenReturn(lastLocation)

        Mockito.`when`(temperatureProvider.getCelsiusTemperatureAt(lastLocation)).thenReturn(18f)

        Mockito.`when`(temperatureProvider.getCelsiusTemperatureAt(currentLocation)).thenReturn(21f)

        temperaturePresenter.start()

        val inOrder = Mockito.inOrder(temperatureProvider, view)

        inOrder.verify<TemperatureProvider>(temperatureProvider)
                .getCelsiusTemperatureAt(lastLocation)

        inOrder.verify<TemperatureProvider>(temperatureProvider)
                .getCelsiusTemperatureAt(currentLocation)

        inOrder.verify<View>(view).displayTemperature(18f)

        inOrder.verify<View>(view).displayTemperature(21f)
    }

}