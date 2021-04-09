package org.romeo.headhounterclient.model.repo

import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import org.romeo.headhounterclient.model.entity.vacancy.vacancy_full.VacancyFull
import org.romeo.headhounterclient.model.entity.vacancy.vacancy_short.VacancyShort
import org.romeo.headhounterclient.model.room.db_workers.IVacanciesFullDbWorker
import org.romeo.headhounterclient.model.room.db_workers.IVacanciesShortDbWorker

class FavoritesRepo(
    private val repo: IFullVacanciesRepo,
    private val fullWorker: IVacanciesFullDbWorker,
    private val shortWorker: IVacanciesShortDbWorker
) : IFavoritesRepo {

    override fun addToFavorites(vacancyShort: VacancyShort): Completable =
        repo.getVacancyFullByUrl(vacancyShort.url)
            .flatMapCompletable { full ->
                shortWorker.saveToDb(vacancyShort)
                    .mergeWith(
                        fullWorker.saveToDb(full, vacancyShort.url)
                    )
            }.subscribeOn(Schedulers.io())

    override fun isFavorite(vacancyShort: VacancyShort): Single<Boolean> =
        shortWorker.isFavorite(vacancyShort).subscribeOn(Schedulers.io())

    override fun getAllFavoritesShort(): Single<List<VacancyShort>> =
        shortWorker.getAll().subscribeOn(Schedulers.io())

    override fun getVacancyFullByUrl(url: String): Single<VacancyFull> =
        fullWorker.getByUrl(url).subscribeOn(Schedulers.io())

    override fun deleteFromFavorites(vacancyShort: VacancyShort): Completable =
        shortWorker.delete(vacancyShort).subscribeOn(Schedulers.io())
}