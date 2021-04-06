package org.romeo.headhounterclient.model.entity.vacancy_full

import com.google.gson.annotations.Expose

data class Employer(
    @Expose val name: String,
    @Expose val url: String,
    @Expose val logoUrls: LogoUrls,
    @Expose val alternativeUrl: String
)