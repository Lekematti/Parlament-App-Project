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
@Dao
interface MemberOfParliamentDAO{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(entry: MemberOfParliament)
    @Query("select * from MemberOfParliament")
    fun getAll(): LiveData<List<MemberOfParliament>>
    //@Query("select * from MemberOfParliament where timestamp > :key")
    //fun getAllSince(key: Long): LiveData<List<MemberOfParliament>>
    //@Query("SELECT * FROM MembersOfParliament WHERE party = :String")
    //fun getMembers(party: String): LiveData<List<MemberOfParliament>>
    //SELECT lastname, firstname from memberofparliament where party
}
/* val selectedParty = partiesList[position].partyName
        // Here you can use the selectedParty variable to retrieve the members of the selected party using a SQL query
        // For example:
        val query = "SELECT MembersOfParliament.firstname, MembersOfParliament.lastname FROM MembersOfParliament WHERE MembersOfParliament.party = '$selectedParty'"*/