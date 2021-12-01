package com.example.f1driverapp.webaccess

import com.example.f1driverapp.data.DriverEntity
import retrofit2.http.GET

interface DriverApi {

    // I simply get the json file, however you will probally have an API endpoint in here from a proper Rest API
    @GET("f1Driver.json")
    suspend fun getDrivers() : List<DriverEntity>
}