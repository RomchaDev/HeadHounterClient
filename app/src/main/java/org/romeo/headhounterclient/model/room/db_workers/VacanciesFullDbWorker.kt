package org.romeo.headhounterclient.model.room.db_workers

import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import org.romeo.headhounterclient.model.entity.vacancy.vacancy_full.VacancyFull
import org.romeo.headhounterclient.model.room.dao.VacanciesFullDao
import org.romeo.headhounterclient.model.room.entity.RoomVacancyFull

class VacanciesFullDbWorker(private val dao: VacanciesFullDao) : IVacanciesFullDbWorker {

    override fun saveToDb(item: VacancyFull, url: String): Completable =
        Completable.fromAction {
            dao.insert(
                RoomVacancyFull
                    .fromVacancyFull(item, url)
            )
        }

    override fun getByUrl(shortUrl: String): Single<VacancyFull> =
        Single.fromCallable {
            VacancyFull.fromRoomVacancyFull(
                dao.getVacancyByUrl(shortUrl)
            )
        }
}