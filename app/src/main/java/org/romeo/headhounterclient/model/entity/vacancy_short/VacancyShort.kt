package org.romeo.headhounterclient.model.entity.vacancy_short

import com.google.gson.annotations.Expose
import org.romeo.headhounterclient.model.entity.Area
import org.romeo.headhounterclient.model.entity.Salary

data class VacancyShort(
    @Expose val name: String,
    @Expose val alternativeUrl: String,
    @Expose val area: Area?,
    @Expose val salary: Salary?,
    @Expose val snippet: Snippet
)