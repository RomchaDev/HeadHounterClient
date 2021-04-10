package org.romeo.headhounterclient.dagger.module.db

import dagger.Module
import dagger.Provides
import org.romeo.headhounterclient.model.room.db.HeadHaunterDb

@Module
class DaoModule {

    @Provides
    fun vacancyFullDao(db: HeadHaunterDb) = db.vacanciesFullDao


    @Provides
    fun vacancyShortDao(db: HeadHaunterDb) = db.vacanciesShortDao

    @Provides
    fun filtersRepo(db: HeadHaunterDb) = db.filtersDao
}