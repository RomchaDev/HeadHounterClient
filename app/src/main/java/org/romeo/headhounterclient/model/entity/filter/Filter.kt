package org.romeo.headhounterclient.model.entity.filter

import org.romeo.headhounterclient.model.room.entity.RoomFilter

open class Filter(
    var location: String
) {
    companion object {
        fun fromRoomFilter(filter: RoomFilter) =
            Filter(filter.location)
    }
}