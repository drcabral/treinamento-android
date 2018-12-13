package com.thoughtworks.boardingpass.model

import android.os.Parcel
import android.os.Parcelable


data class BoardingPass(val id: String,
                   val name: String,
                   val url: String): Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(name)
        parcel.writeString(url)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<BoardingPass> {
        override fun createFromParcel(parcel: Parcel): BoardingPass {
            return BoardingPass(parcel)
        }

        override fun newArray(size: Int): Array<BoardingPass?> {
            return arrayOfNulls(size)
        }
    }
}