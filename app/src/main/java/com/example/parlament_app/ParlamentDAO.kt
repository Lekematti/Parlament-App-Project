// 3.3.2023
// Leo Koskimäki
// 2201352
// ParlamentDAO contains a Entity and Dao.
// The ParlamentDatabase uses these to get data.
// Also ParlamentRepository uses this.
package com.example.parlament_app

import androidx.lifecycle.LiveData
import androidx.room.*

@Entity
data class MemberOfParliament (
    @PrimaryKey
    val hetekaId: Int,
    val seatNumber: Int = 0,
    val lastname: String,
    val firstname: String,
    val party: String,
    val minister: Boolean = false,
    val pictureUrl: String = ""
)

//DAO that contains the sql and functions to get data
@Dao
interface MemberOfParliamentDAO{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(entry: MemberOfParliament)
    @Query("select * from MemberOfParliament")
    fun getAll(): LiveData<List<MemberOfParliament>>
    @Query("select * from MemberOfParliament where party = :party")
    fun getMembers(party: String): LiveData<List<MemberOfParliament>>
}