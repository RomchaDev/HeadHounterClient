package org.romeo.headhounterclient.model.room.db_workers

import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import org.romeo.headhounterclient.model.entity.filter.Filter
import org.romeo.headhounterclient.model.room.dao.FiltersDao
import org.romeo.headhounterclient.model.room.entity.RoomFilter

class FiltersDbWorker(
    private val dao: FiltersDao
) : IFiltersDbWorker {
    override fun insertFilter(filter: Filter): Completable =
        Completable.fromAction {
            dao.insert(
                RoomFilter.fromFilter(filter)
            )
        }

    override fun getFilter(): Single<Filter?> =
        Single.fromCallable {
            try {
                Filter.fromRoomFilter(
                    dao.getAllFilters()[0]
                )
            } catch (e: Throwable) {
                null
            }
        }

    override fun clearTable(): Completable =
        Completable.fromAction {
            dao.clear()
        }
}