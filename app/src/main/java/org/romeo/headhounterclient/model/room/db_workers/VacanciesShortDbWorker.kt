package org.romeo.headhounterclient.model.room.db_workers

import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import org.romeo.headhounterclient.model.entity.vacancy.vacancy_short.VacancyShort
import org.romeo.headhounterclient.model.room.dao.VacanciesShortDao
import org.romeo.headhounterclient.model.room.entity.RoomVacancyShort

class VacanciesShortDbWorker(
    private val dao: VacanciesShortDao
) : IVacanciesShortDbWorker {

    override fun saveToDb(item: VacancyShort): Completable =
        Completable.fromAction {
            dao.insert(RoomVacancyShort.fromVacancyShort(item))
        }

    override fun delete(vacancy: VacancyShort): Completable =
        Completable.fromAction {
            dao.delete(RoomVacancyShort.fromVacancyShort(vacancy))
        }

    override fun isFavorite(vacancy: VacancyShort): Single<Boolean> =
        Single.fromCallable {
            dao.isFavoriteByUrl(vacancy.url)
        }
}