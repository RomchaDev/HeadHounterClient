package org.romeo.headhounterclient.model.room.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import org.romeo.headhounterclient.model.entity.vacancy.AbstractVacancy
import org.romeo.headhounterclient.model.entity.vacancy.Area
import org.romeo.headhounterclient.model.entity.vacancy.Salary
import org.romeo.headhounterclient.model.entity.vacancy.vacancy_full.Employer
import org.romeo.headhounterclient.model.entity.vacancy.vacancy_full.VacancyFull

@Entity(
    foreignKeys = [
        ForeignKey(
            entity = RoomVacancyShort::class,
            parentColumns = ["url"],
            childColumns = ["shortUrl"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class RoomVacancyFull(
    @PrimaryKey val shortUrl: String,
    @Embedded(prefix = "salary") override val salary: Salary?,
    @Embedded(prefix = "area") override val area: Area?,
    @Embedded(prefix = "employer") val employer: Employer,
    val applyAlternateUrl: String,
    override val name: String,
    val description: String,
) : AbstractVacancy {

    companion object {
        fun fromVacancyFull(vacancy: VacancyFull, url: String) =
            with(vacancy) {
                RoomVacancyFull(
                    name = name,
                    area = area,
                    salary = salary,
                    employer = employer,
                    description = description,
                    applyAlternateUrl = applyAlternateUrl,
                    shortUrl = url
                )
            }
    }
}