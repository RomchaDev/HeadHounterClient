package org.romeo.headhounterclient.model.repo

import io.reactivex.rxjava3.core.Single
import org.romeo.headhounterclient.model.entity.vacancy.vacancy_full.VacancyFull

interface IFullVacanciesRepo {
    fun getVacancyFullByUrl(url: String): Single<VacancyFull>
}