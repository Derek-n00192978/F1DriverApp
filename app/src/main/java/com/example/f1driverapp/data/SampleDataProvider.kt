package com.example.f1driverapp.data

import java.util.*

class SampleDataProvider {

    // Companion objects are is like creating static values in Java
    companion object {

        private val sampleName1 = "Max Verstappen"
        private val sampleName2 = "Daniel Ricarido"
        private val sampleName3 = "Mick Shumacher"
        private val sampleName4 = "Sebastian Vettel "

        private val cal = Calendar.getInstance()
        private val date = cal.set(20, 11, 22)

        private val sampleCountry1 = "Dutch"
        private val sampleCountry2 = "Australia"
        private val sampleCountry3 = "Germany"
        private val sampleCountry4 = "Germany"


        private fun getDate(diff: Long): Date {
            return Date(Date().time + diff)
        }

        //  private fun setDate() :

        fun getDrivers() = arrayListOf(
            DriverEntity(sampleName1, getDate(0), sampleCountry1),
            DriverEntity(sampleName2, getDate(1), sampleCountry2),
            DriverEntity(sampleName3, getDate(2), sampleCountry3),
            DriverEntity(sampleName4, getDate(3), sampleCountry4)

        )

    }
}