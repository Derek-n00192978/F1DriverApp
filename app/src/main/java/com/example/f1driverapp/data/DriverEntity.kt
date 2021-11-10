package com.example.f1driverapp.data

import android.os.Parcel
import android.os.Parcelable
import com.example.f1driverapp.NEW_DRIVER_ID
import java.util.*

// data means the class is going to have some properties, will have at least one primary constructor, and have functions such as equals() toString...
// See https://www.javatpoint.com/kotlin-data-class for a comparison of Java and Kotlin classes
data class DriverEntity (
    var id: Int,
    var name: String?,
    var dob: Date,
    var country: String?
) : Parcelable
{
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        TODO("dob"),
        parcel.readString()
    ) {
}

    // no arguments constructor - if no values are passed in this one is executed.
    constructor() : this(NEW_DRIVER_ID, "", Date(), "")
    // New Driver - this constructor is called when the driver a name, dob and country, but no driver ID yet
    constructor(name: String, dob: Date, country: String) : this(NEW_DRIVER_ID, name, dob, country)

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(name)
        parcel.writeString(country)
    }

    override fun describeContents(): Int {
        return 0
    }
    companion object CREATOR : Parcelable.Creator<DriverEntity> {
        override fun createFromParcel(parcel: Parcel): DriverEntity {
            return DriverEntity(parcel)
        }

        override fun newArray(size: Int): Array<DriverEntity?> {
            return arrayOfNulls(size)
        }
    }
}