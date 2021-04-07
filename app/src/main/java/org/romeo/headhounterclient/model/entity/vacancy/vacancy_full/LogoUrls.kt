package org.romeo.headhounterclient.model.entity.vacancy.vacancy_full

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class LogoUrls(
    @SerializedName("240")
    @Expose
    val big: String
)