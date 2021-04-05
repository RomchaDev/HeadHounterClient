package org.romeo.headhounterclient.model.entity

import com.google.gson.annotations.Expose

data class Employer(
    @Expose val name: String,
    @Expose val url: String,
    @Expose val logoUrls: Array<String>?
)