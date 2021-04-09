package org.romeo.headhounterclient.model.entity.vacancy

import android.os.Parcelable
import com.google.gson.annotations.Expose
import kotlinx.parcelize.Parcelize

@Parcelize
data class Salary(
    @Expose val from: Int?,
    @Expose val to: Int?,
    @Expose val currency: String
) : Parcelable
