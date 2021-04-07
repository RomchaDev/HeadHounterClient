package org.romeo.headhounterclient.model.api

import io.reactivex.rxjava3.core.Single
import org.romeo.headhounterclient.model.entity.vacancy.vacancy_full.VacancyFull
import org.romeo.headhounterclient.model.entity.vacancy.vacancy_short.Items
import retrofit2.http.GET
import retrofit2.http.QueryMap
import retrofit2.http.Url

interface RetrofitService {

    @GET("/vacancies")
    fun getVacancies(@QueryMap args: Map<String, String>): Single<Items>

    @GET
    fun getVacancy(@Url url: String): Single<VacancyFull>
}