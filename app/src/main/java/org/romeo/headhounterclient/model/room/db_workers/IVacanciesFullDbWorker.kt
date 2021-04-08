package org.romeo.headhounterclient.model.room.db_workers

import io.reactivex.rxjava3.core.Completable
import org.romeo.headhounterclient.model.entity.vacancy.vacancy_full.VacancyFull

interface IVacanciesFullDbWorker {
    fun saveToDb(item: VacancyFull, url: String): Completable
}