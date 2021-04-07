package org.romeo.headhounterclient.model.entity.vacancy

import com.google.gson.annotations.Expose

data class Salary(
    @Expose val from: Int?,
    @Expose val to: Int?,
    @Expose val currency: String
)
