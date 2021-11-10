package com.example.f1driverapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.f1driverapp.data.DriverEntity
import com.example.f1driverapp.data.SampleDataProvider
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel  : ViewModel() {

    // MutableLiveData - means this list can be changed at runtime
    val driverList = MutableLiveData<List<DriverEntity>>()

    // this code is only executed as the class is initialised
    init {
        // here we get the plant list data to share with the user interface
        // currently it's take from the SampleDataProvider class, later will come from the database
        driverList.value = SampleDataProvider.getDrivers()
    }

}