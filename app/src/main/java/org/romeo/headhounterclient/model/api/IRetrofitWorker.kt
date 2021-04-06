package org.romeo.headhounterclient.model.api

import io.reactivex.rxjava3.core.Single
import org.romeo.headhounterclient.model.entity.vacancy_short.VacancyShort

interface IRetrofitWorker {
    fun getVacanciesSingleBySearch(search: String): Single<List<VacancyShort>>
}