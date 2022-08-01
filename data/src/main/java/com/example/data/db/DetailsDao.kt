package com.example.data.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.data.model.detail.DetailsAPIResponseImpl

@Dao
interface DetailsDao {
    @Query("SELECT * FROM details_table")
    fun getAll(): List<DetailsAPIResponseImpl>

    @Insert
    fun insertAll(vararg detail: DetailsAPIResponseImpl)

    @Delete
    fun delete(detail: DetailsAPIResponseImpl)
}