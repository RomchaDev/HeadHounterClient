package org.romeo.headhounterclient.model.repo

import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import org.romeo.headhounterclient.model.api.IRetrofitWorker
import org.romeo.headhounterclient.model.entity.vacancy.vacancy_short.VacancyShort

class ShortVacanciesRepo(private val retrofit: IRetrofitWorker) : IShortVacanciesRepo {
    override fun getVacanciesSingleBySearch(search: String): Single<List<VacancyShort>> =
        retrofit.getVacanciesSingleBySearch(search).subscribeOn(Schedulers.io())
}