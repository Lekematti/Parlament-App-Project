package com.example.parlament_app

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import java.lang.reflect.Member

class MainActivityViewModel: ViewModel() {
    var member: MutableLiveData<List<ParliamentMembersData>> = MutableLiveData()

    fun readMembers() {
        viewModelScope.launch {
            try {
                member.value = ParlamentApi.retrofitService.getParlamentList()
                println("Read members from parlament with great success.")
            } catch (e: Exception) {
                println("No luck in reading members from parlament: ${e}")
            }
        }
    }
}