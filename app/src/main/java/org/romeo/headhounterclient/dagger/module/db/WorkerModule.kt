package org.romeo.headhounterclient.dagger.module.db

import dagger.Module
import dagger.Provides
import org.romeo.headhounterclient.model.room.dao.VacanciesFullDao
import org.romeo.headhounterclient.model.room.dao.VacanciesShortDao
import org.romeo.headhounterclient.model.room.db_workers.IVacanciesFullDbWorker
import org.romeo.headhounterclient.model.room.db_workers.IVacanciesShortDbWorker
import org.romeo.headhounterclient.model.room.db_workers.VacanciesFullDbWorker
import org.romeo.headhounterclient.model.room.db_workers.VacanciesShortDbWorker

@Module
class WorkerModule {
    @Provides
    fun shortWorker(dao: VacanciesShortDao): IVacanciesShortDbWorker =
        VacanciesShortDbWorker(dao)


    @Provides
    fun fullWorker(dao: VacanciesFullDao): IVacanciesFullDbWorker =
        VacanciesFullDbWorker(dao)
}