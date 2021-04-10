package org.romeo.headhounterclient.model.room.dao

import androidx.room.*
import org.romeo.headhounterclient.model.room.entity.RoomFilter

@Dao
interface FiltersDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(filter: RoomFilter)

    @Query("SELECT * FROM RoomFilter")
    fun getAllFilters(): List<RoomFilter>

    @Query("DELETE FROM RoomFilter")
    fun clear()
}