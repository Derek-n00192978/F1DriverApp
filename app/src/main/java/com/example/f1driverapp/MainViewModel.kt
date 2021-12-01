package com.example.f1driverapp

import android.util.Log
import androidx.lifecycle.*
import com.example.f1driverapp.data.DriverEntity
import com.example.f1driverapp.data.SampleDataProvider
import com.example.f1driverapp.webaccess.RetrofitInstance

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel  : ViewModel() {

    // MutableLiveData - means this list can be changed at runtime
    val _drivers = MutableLiveData<List<DriverEntity>> =  MutableLiveData()

    // Driver is exposed to the UI - Fragment
    val drivers: LiveData<List<DriverEntity>>
    //get() This is a greater() function, which returns the list of plants as LiveData
    get() = _drivers

    private val _isLoading = MutableLiveData(false)
    val isLoading: LiveData<Boolean>
        get() = _isLoading

    // this code is only executed as the class is initialised
    // No Longer get the data from SampleDataProvider
    init {
        // here we get the plant list data to share with the user interface
        // currently it's take from the SampleDataProvider class, later will come from the database
//        driverList.value = SampleDataProvider.
        getDrivers()
    }
    private fun getDrivers() {
        //web-access so run in a background thread - Coroutine
        viewModelScope.launch {
            _isLoading.value = true
            val fetchDrivers = RetrofitInstance.api.getDrivers()
            Log.i(TAG, "List Of Drivers : $fetchedDrivers")
            _drivers.value = fetchedDrivers
            _isLoading.value = false
        }
    }

}