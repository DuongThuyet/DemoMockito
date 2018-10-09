package com.example.duongnguyen.demomoc

class TemperaturePresenter(
        private val locationProvider: LocationProvider,
        private val temperatureProvider: TemperatureProvider,
        private val view: View) {

    fun start() {
        var lastLocation = locationProvider.getLastKnownLocation()

        val exactLocation = locationProvider.getExactLocation()

        val inaccurateTemperature = temperatureProvider.getCelsiusTemperatureAt(lastLocation)

        val accurateTemperature = temperatureProvider.getCelsiusTemperatureAt(exactLocation)

            view.displayTemperature(inaccurateTemperature)

            view.displayTemperature(accurateTemperature)

    }
}

class Coordinate(var latitude: Double, longitude: Double)

interface LocationProvider {
    fun getLastKnownLocation(): Coordinate
    fun getExactLocation(): Coordinate
}

interface TemperatureProvider {
    fun getCelsiusTemperatureAt(coordinate: Coordinate): Float
}

interface View {
    fun displayTemperature(temperature: Float)
}