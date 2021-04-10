package org.romeo.headhounterclient.model.repo

import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import org.romeo.headhounterclient.model.entity.filter.Filter

interface IFiltersRepo {
    fun getFilter(): Single<Filter?>
    fun replaceFilter(filter: Filter): Completable
}