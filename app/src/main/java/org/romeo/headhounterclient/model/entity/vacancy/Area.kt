package org.romeo.headhounterclient.model.entity.vacancy

import android.os.Parcelable
import com.google.gson.annotations.Expose
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Area(
    @Expose val name: String
) : Parcelable