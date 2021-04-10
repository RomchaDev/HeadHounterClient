package org.romeo.headhounterclient.model.repo

import io.reactivex.rxjava3.core.Single

interface ILocationRepo {
    fun getUserCountry(): Single<String?>
}