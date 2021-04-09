package org.romeo.headhounterclient.model.entity.vacancy.vacancy_full

import android.os.Parcelable
import androidx.room.Embedded
import com.google.gson.annotations.Expose
import kotlinx.parcelize.Parcelize

@Parcelize
data class Employer(
    //@Expose val name: String,
    @Expose val id: Int,
    @Expose @Embedded val logoUrls: LogoUrls?,
    //@Expose val alternativeUrl: String
) : Parcelable