package org.romeo.headhounterclient.model.repo

import io.reactivex.rxjava3.core.Single
import org.romeo.headhounterclient.model.entity.vacancy_short.VacancyShort

interface IShortVacanciesRepo {
    fun getVacanciesSingleBySearch(search: String): Single<List<VacancyShort>>
}