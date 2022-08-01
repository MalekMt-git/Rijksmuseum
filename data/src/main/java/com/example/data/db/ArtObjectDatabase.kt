package com.example.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.data.model.detail.DetailsAPIResponseImpl

@Database(entities = [DetailsAPIResponseImpl::class], version = 1)
abstract class ArtObjectDatabase : RoomDatabase() {
    abstract fun detailsDao(): DetailsDao
}
