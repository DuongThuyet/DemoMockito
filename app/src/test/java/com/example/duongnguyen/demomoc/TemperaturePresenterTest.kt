package com.example.duongnguyen.demomoc

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.*


class TemperaturePresenterTest {

    private val lastLocation = Coordinate(41.5, 8.9)

    private val currentLocation = Coordinate(38.7, 9.7)

    private val locationProvider: LocationProvider = mock {

        on { getLastKnownLocation() }.then { lastLocation }

        on { getExactLocation() }.then { currentLocation }

    }

    private var temperatureProvider: TemperatureProvider = mock()

    private var view = mock(View::class.java)

     var temperaturePresenter = TemperaturePresenter(locationProvider = locationProvider,
            temperatureProvider = temperatureProvider,
            view = view)


    @Test
    fun `display temperature for last known location first, and then for exact location`() {

        whenever(temperatureProvider.getCelsiusTemperatureAt(lastLocation)).thenReturn(18f)

        whenever(temperatureProvider.getCelsiusTemperatureAt(currentLocation)).thenReturn(21f)

        temperaturePresenter.start()

        Mockito.inOrder(temperatureProvider, view).apply {

            verify(temperatureProvider).getCelsiusTemperatureAt(lastLocation)

            verify(temperatureProvider).getCelsiusTemperatureAt(currentLocation)

            verify(view).displayTemperature(18f)

            verify(view).displayTemperature(21f)

        }

    }

}