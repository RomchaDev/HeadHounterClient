package org.romeo.headhounterclient.model.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import org.romeo.headhounterclient.model.room.entity.RoomVacancyFull

@Dao
interface VacanciesFullDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vacancy: RoomVacancyFull)
}