package com.example.parlament_app

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Query


@Entity
data class OpsLogEntry{
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val timestamp: Long,
    val amount: Int,
    val note: String = ""
    )
}

@Dao
interface OpsLogDAO {
    @insert
    suspend fun insert( entry: OpsLogEntry)
    @Query("select * from OpsLogEntry")
    fun getAll(): LiveData<List<OpsLogEntry>>
    @Query("select * from OpsLogEntry where timestamp > :key")
    fun getAllSince(key: Long): LiveData<List<OpsLogEntry>>
}