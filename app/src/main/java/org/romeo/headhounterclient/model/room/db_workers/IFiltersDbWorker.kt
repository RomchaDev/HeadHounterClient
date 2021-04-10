package org.romeo.headhounterclient.model.room.db_workers

import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import org.romeo.headhounterclient.model.entity.filter.Filter

interface IFiltersDbWorker {
    fun insertFilter(filter: Filter): Completable
    fun getFilter(): Single<Filter?>
    fun clearTable(): Completable
}