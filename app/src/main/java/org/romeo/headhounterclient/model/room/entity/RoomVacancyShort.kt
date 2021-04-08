package org.romeo.headhounterclient.model.room.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import org.romeo.headhounterclient.model.entity.vacancy.AbstractVacancy
import org.romeo.headhounterclient.model.entity.vacancy.Area
import org.romeo.headhounterclient.model.entity.vacancy.Salary
import org.romeo.headhounterclient.model.entity.vacancy.vacancy_short.Snippet
import org.romeo.headhounterclient.model.entity.vacancy.vacancy_short.VacancyShort

@Entity
class RoomVacancyShort(
    @PrimaryKey val url: String,
    @Embedded(prefix = "area") override val area: Area?,
    @Embedded(prefix = "salary") override val salary: Salary?,
    @Embedded(prefix = "snippet") val snippet: Snippet,
    override val name: String,
    var isFavorite: Boolean
) : AbstractVacancy {

    companion object {
        fun fromVacancyShort(vacancy: VacancyShort) =
            with(vacancy) {
                RoomVacancyShort(
                    name = name,
                    area = area,
                    salary = salary,
                    url = url,
                    snippet = snippet,
                    isFavorite = isFavorite,
                )
            }
    }
}