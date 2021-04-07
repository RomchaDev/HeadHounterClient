package org.romeo.headhounterclient.model.entity.vacancy.vacancy_short

import com.google.gson.annotations.Expose
import org.romeo.headhounterclient.model.entity.vacancy.AbstractVacancy
import org.romeo.headhounterclient.model.entity.vacancy.Area
import org.romeo.headhounterclient.model.entity.vacancy.Salary

data class VacancyShort(
    @Expose override val name: String,
    @Expose override val area: Area?,
    @Expose override val salary: Salary?,
    @Expose val url: String,
    @Expose val snippet: Snippet
) : AbstractVacancy