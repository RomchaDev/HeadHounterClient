package org.romeo.headhounterclient.model.repo

import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import org.romeo.headhounterclient.model.entity.vacancy.vacancy_full.VacancyFull
import org.romeo.headhounterclient.model.entity.vacancy.vacancy_short.VacancyShort

interface IFavoritesRepo: IFullVacanciesRepo {
    fun addToFavorites(vacancyShort: VacancyShort): Completable
    fun deleteFromFavorites(vacancyShort: VacancyShort): Completable
    fun isFavorite(vacancyShort: VacancyShort): Single<Boolean>
    fun getAllFavoritesShort(): Single<List<VacancyShort>>
}