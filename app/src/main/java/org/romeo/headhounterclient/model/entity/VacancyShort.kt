package org.romeo.headhounterclient.model.entity

import com.google.gson.annotations.Expose

data class VacancyShort(
    @Expose val name: String,
    @Expose val alternativeUrl: String,
    @Expose val area: Area?,
    @Expose val salary: Salary?,
    @Expose val snippet: Snippet
)