package org.romeo.headhounterclient.dagger.module.db

import dagger.Module
import dagger.Provides
import org.romeo.headhounterclient.model.room.dao.FiltersDao
import org.romeo.headhounterclient.model.room.dao.VacanciesFullDao
import org.romeo.headhounterclient.model.room.dao.VacanciesShortDao
import org.romeo.headhounterclient.model.room.db_workers.*

@Module
class WorkerModule {
    @Provides
    fun shortWorker(dao: VacanciesShortDao): IVacanciesShortDbWorker =
        VacanciesShortDbWorker(dao)


    @Provides
    fun fullWorker(dao: VacanciesFullDao): IVacanciesFullDbWorker =
        VacanciesFullDbWorker(dao)

    @Provides
    fun favoritesWorker(dao: FiltersDao): IFiltersDbWorker =
        FiltersDbWorker(dao)
}