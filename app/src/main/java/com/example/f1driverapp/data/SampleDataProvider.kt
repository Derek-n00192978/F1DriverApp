package com.example.f1driverapp.data

class SampleDataProvider {

    // Companion objects are is like creating static values in Java
    companion object {

        private val sampleId1 = "1"
        private val sampleId2 = "2"
        private val sampleId3 = "3"
        private val sampleId4 = "4"


        private val sampleDriverId1 = "max_verstappen"
        private val sampleDriverId2 = "ricarido"
        private val sampleDriverId3 = "shumacher"
        private val sampleDriverId4 = "vettel "

        private val sampleCode1 = "VER"
        private val sampleCode2 = "RIC"
        private val sampleCode3 = "SHU"
        private val sampleCode4 = "VET"

        private val sampleUrl1 = "http://en.wikipedia.org/wiki/Max_Verstappen"
        private val sampleUrl2 = "http://en.wikipedia.org/wiki/Daniel_Ricciardo"
        private val sampleUrl3 = "http://en.wikipedia.org/wiki/Mick_Shunacher"
        private val sampleUrl4 = "http://en.wikipedia.org/wiki/Sebastian_Vettel"

        private val samplePermanentNumber1 = "33"
        private val samplePermanentNumber2 = "3"
        private val samplePermanentNumber3 = "47"
        private val samplePermanentNumber4 = "5"

        private val sampleGivenName1 = "Max Verstappen"
        private val sampleGivenName2 = "Daniel Ricciardo"
        private val sampleGivenName3 = "Mick Shumacher"
        private val sampleGivenName4 = "Sebastian Vettel"

        private val sampledob1 = "1997-09-30"
        private val sampledob2 = "1989-07-01"
        private val sampledob3 = "1999-09-30"
        private val sampledob4 = "1987-07-03"



        private val sampleNationality1 = "Dutch"
        private val sampleNationality2 = "Australia"
        private val sampleNationality3 = "Germany"
        private val sampleNationality4 = "Germany"


        fun getDrivers() = arrayListOf(
            DriverEntity(sampleDriverId1, sampleCode1, sampleUrl1, samplePermanentNumber1, sampleGivenName1, sampledob1, sampleNationality1),
            DriverEntity(sampleDriverId2, sampleCode2, sampleUrl2, samplePermanentNumber2, sampleGivenName2, sampledob2, sampleNationality2),
            DriverEntity(sampleDriverId3, sampleCode3, sampleUrl3, samplePermanentNumber3, sampleGivenName3, sampledob3, sampleNationality3),
            DriverEntity(sampleDriverId4, sampleCode4, sampleUrl4, samplePermanentNumber4, sampleGivenName4, sampledob4, sampleNationality4),

        )

    }
}