package org.romeo.headhounterclient.model.entity.vacancy.vacancy_full

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class LogoUrls(
    @SerializedName("240")
    @Expose
    val big: String
) : Parcelable