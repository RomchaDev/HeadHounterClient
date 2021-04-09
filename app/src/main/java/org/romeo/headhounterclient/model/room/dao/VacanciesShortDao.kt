package org.romeo.headhounterclient.model.room.dao

import androidx.room.*
import org.romeo.headhounterclient.model.room.entity.RoomVacancyShort

@Dao
interface VacanciesShortDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vacancy: RoomVacancyShort)

    @Delete
    fun delete(vacancy: RoomVacancyShort)

    @Query("SELECT isFavorite FROM RoomVacancyShort WHERE url = :url")
    fun isFavoriteByUrl(url: String): Boolean

    @Query("SELECT * FROM RoomVacancyShort")
    fun getAll(): List<RoomVacancyShort>
}