package org.romeo.headhounterclient.model.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import org.romeo.headhounterclient.model.entity.filter.Filter

@Entity
data class RoomFilter(
    @PrimaryKey
    val location: String
) {
    companion object {
        fun fromFilter(filter: Filter) =
            RoomFilter(filter.location)
    }
}