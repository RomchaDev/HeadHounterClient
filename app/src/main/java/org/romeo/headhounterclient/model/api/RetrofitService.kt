package org.romeo.headhounterclient.model.api

import io.reactivex.rxjava3.core.Single
import org.romeo.headhounterclient.model.entity.vacancy_short.Items
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface RetrofitService {

    @GET("/vacancies")
    fun getVacancies(@QueryMap args: Map<String, String>): Single<Items>
}