// 3.3.2023
// Leo Koskimäki
// 2201352
// Repository used for getting data from Dao
package com.example.parlament_app

import androidx.lifecycle.LiveData

object ParlamentRepository {
    private val dao = ParlamentDatabase.getInstance().memberOfParliamentDAO
    val logData: LiveData<List<MemberOfParliament>> = dao.getAll()
fun getMembers(party:String): LiveData<List<MemberOfParliament>>{
    return dao.getMembers(party)
    }
}