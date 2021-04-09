package org.romeo.headhounterclient.model.room.db_workers

import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import org.romeo.headhounterclient.model.entity.vacancy.vacancy_full.VacancyFull

interface IVacanciesFullDbWorker {
    fun saveToDb(item: VacancyFull, url: String): Completable
    fun getByUrl(shortUrl: String): Single<VacancyFull>
}