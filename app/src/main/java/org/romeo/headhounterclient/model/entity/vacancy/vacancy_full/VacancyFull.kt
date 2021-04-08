package org.romeo.headhounterclient.model.entity.vacancy.vacancy_full

import com.google.gson.annotations.Expose
import org.romeo.headhounterclient.model.entity.vacancy.AbstractVacancy
import org.romeo.headhounterclient.model.entity.vacancy.Area
import org.romeo.headhounterclient.model.entity.vacancy.Salary
import org.romeo.headhounterclient.model.room.entity.RoomVacancyFull

data class VacancyFull(
    @Expose override val name: String,
    @Expose override val salary: Salary?,
    @Expose override val area: Area?,
    @Expose val description: String,
    @Expose val employer: Employer,
    //@Expose val publishedAt: String,
    @Expose val applyAlternateUrl: String,
    //@Expose val alternateUrl: String,
    //@Expose val schedule: Schedule
): AbstractVacancy {
    companion object {
        fun fromRoomVacancyFull(vacancy: RoomVacancyFull) =
            with(vacancy) {
                VacancyFull(
                    name = name,
                    area = area,
                    salary = salary,
                    employer = employer,
                    description = description,
                    applyAlternateUrl = applyAlternateUrl
                )
            }
    }
}