package org.romeo.headhounterclient.model.entity.vacancy.vacancy_short

import android.os.Parcelable
import com.google.gson.annotations.Expose
import kotlinx.parcelize.Parcelize
import org.romeo.headhounterclient.model.entity.vacancy.AbstractVacancy
import org.romeo.headhounterclient.model.entity.vacancy.Area
import org.romeo.headhounterclient.model.entity.vacancy.Salary
import org.romeo.headhounterclient.model.room.entity.RoomVacancyShort

@Parcelize
data class VacancyShort(
    @Expose override val name: String,
    @Expose override val area: Area?,
    @Expose override val salary: Salary?,
    @Expose val url: String,
    @Expose val snippet: Snippet,
    var isFavorite: Boolean = false
) : AbstractVacancy, Parcelable {

    companion object {
        fun fromRoomVacancyShort(vacancy: RoomVacancyShort) =
            with(vacancy) {
                VacancyShort(
                    name = name,
                    area = area,
                    salary = salary,
                    url = url,
                    snippet = snippet,
                    isFavorite = isFavorite
                )
            }
    }
}