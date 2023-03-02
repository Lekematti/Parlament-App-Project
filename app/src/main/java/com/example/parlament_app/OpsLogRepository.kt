package com.example.parlament_app

import androidx.lifecycle.LiveData

object OpsLogRepository {
    private val dao = ParlamentDatabase.getInstance().memberOfParliamentDAO
    val logData: LiveData<List<MemberOfParliament>> = dao.getAll()

    suspend fun newOpsLogEntry(amount: Int, noteText: String){
        dao.insert(
            MemberOfParliament(hetekaId = 0,seatNumber = 0, firstname = String(), lastname = String(), party = String())
        )
    }
}