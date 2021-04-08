package org.romeo.headhounterclient.model.repo

import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import org.romeo.headhounterclient.model.api.IRetrofitWorker
import org.romeo.headhounterclient.model.entity.vacancy.vacancy_short.VacancyShort

class ShortVacanciesApiRepo(
    private val retrofit: IRetrofitWorker,
    private val favoritesRepo: IFavoritesRepo
) : IShortVacanciesRepo {
    override fun getVacanciesSingleBySearch(search: String): Single<List<VacancyShort>> =
        retrofit.getVacanciesSingleBySearch(search)
            .map { list ->
                list.map { vacancy ->
                    val isFav = favoritesRepo.isFavorite(vacancy)
                        .blockingGet()
                    vacancy.isFavorite = isFav
                    vacancy
                }
            }.subscribeOn(Schedulers.io())
}