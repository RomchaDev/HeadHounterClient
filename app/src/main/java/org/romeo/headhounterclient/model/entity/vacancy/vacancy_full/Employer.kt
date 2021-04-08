package org.romeo.headhounterclient.model.entity.vacancy.vacancy_full

import androidx.room.Embedded
import com.google.gson.annotations.Expose

data class Employer(
    //@Expose val name: String,
    @Expose val id: Int,
    @Expose @Embedded val logoUrls: LogoUrls?,
    //@Expose val alternativeUrl: String
)