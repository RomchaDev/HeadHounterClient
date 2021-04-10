package org.romeo.headhounterclient.model.repo

import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import org.romeo.headhounterclient.model.entity.filter.Filter
import org.romeo.headhounterclient.model.room.db_workers.IFiltersDbWorker

class FiltersRepo(
    private val worker: IFiltersDbWorker
) : IFiltersRepo {
    override fun getFilter(): Single<Filter?> =
        worker.getFilter().subscribeOn(Schedulers.io())

    override fun replaceFilter(filter: Filter): Completable =
        worker.clearTable()
            .concatWith(worker.insertFilter(filter))
            .subscribeOn(Schedulers.io())
}