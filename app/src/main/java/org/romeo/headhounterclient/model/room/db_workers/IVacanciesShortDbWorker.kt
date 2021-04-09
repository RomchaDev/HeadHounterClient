package org.romeo.headhounterclient.model.room.db_workers

import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import org.romeo.headhounterclient.model.entity.vacancy.vacancy_short.VacancyShort

interface IVacanciesShortDbWorker {
    fun saveToDb(item: VacancyShort): Completable
    fun delete(vacancy: VacancyShort): Completable
    fun isFavorite(vacancy: VacancyShort): Single<Boolean>
    fun getAll(): Single<List<VacancyShort>>
}