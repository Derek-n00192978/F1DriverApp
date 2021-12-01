package com.example.f1driverapp.data

import android.os.Parcel
import android.os.Parcelable
import com.example.f1driverapp.NEW_DRIVER_ID

// data means the class is going to have some properties, will have at least one primary constructor, and have functions such as equals() toString...
// See https://www.javatpoint.com/kotlin-data-class for a comparison of Java and Kotlin classes
data class DriverEntity (
    var id: Int,
    var driverId: String?,
    var code: String?,
    var url: String?,
    var permanentNumber: String?,
    var givenName: String?,
    var dob: String?,
    var nationality: String?
) : Parcelable
{
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    // no arguments constructor - if no values are passed in this one is executed.
    constructor() : this(NEW_DRIVER_ID, "","", "", "","", "", "")
    // New Driver - this constructor is called when the driver a name, dob and country, but no driver ID yet
    constructor(driverId: String, code: String, url: String, permanentNumber: String, givenName: String, dob: String, nationality: String) : this(NEW_DRIVER_ID, driverId, code, url, permanentNumber, givenName, dob, nationality)

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        with(parcel) {
            writeInt(id)
            writeString(driverId)
            writeString(code)
            writeString(url)
            writeString(permanentNumber)
            writeString(givenName)
            writeString(dob)
            writeString(nationality)
        }
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