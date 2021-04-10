package org.romeo.headhounterclient.model.room.db

import androidx.room.Database
import androidx.room.RoomDatabase
import org.romeo.headhounterclient.model.room.dao.FiltersDao
import org.romeo.headhounterclient.model.room.dao.VacanciesFullDao
import org.romeo.headhounterclient.model.room.dao.VacanciesShortDao
import org.romeo.headhounterclient.model.room.entity.RoomFilter
import org.romeo.headhounterclient.model.room.entity.RoomVacancyFull
import org.romeo.headhounterclient.model.room.entity.RoomVacancyShort

@Database(
    entities = [
        RoomVacancyShort::class,
        RoomVacancyFull::class,
        RoomFilter::class
    ],

    version = 1
)
abstract class HeadHaunterDb : RoomDatabase(){
    abstract val vacanciesFullDao: VacanciesFullDao
    abstract val vacanciesShortDao: VacanciesShortDao
    abstract val filtersDao: FiltersDao
}