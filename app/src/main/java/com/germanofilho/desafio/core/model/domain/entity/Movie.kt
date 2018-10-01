package com.germanofilho.desafio.core.model.domain.entity

import android.os.Parcel
import android.os.Parcelable

data class Movie(var title : String,
                 var originalTitle : String,
                 var duration: Int,
                 var synopsis: String,
                 var thumbUrl: String,
                 var posterUrl: String) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readInt(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString())

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeString(originalTitle)
        parcel.writeInt(duration)
        parcel.writeString(synopsis)
        parcel.writeString(thumbUrl)
        parcel.writeString(posterUrl)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Movie> {
        override fun createFromParcel(parcel: Parcel): Movie {
            return Movie(parcel)
        }

        override fun newArray(size: Int): Array<Movie?> {
            return arrayOfNulls(size)
        }
    }
}

