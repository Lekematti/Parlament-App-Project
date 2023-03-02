package com.example.parlament_app

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.parlament_app.databinding.ItemPartiesBinding

class PartiesAdapter(val parties: List<String>) : RecyclerView.Adapter<PartyViewHolder>() {
    //private val members = ParliamentMembersData.members

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PartyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = ItemPartiesBinding.inflate(inflater, parent, false)
        return PartyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return parties.size
    }

    override fun onBindViewHolder(holder: PartyViewHolder, position: Int) {
        val party = parties[position]
        holder.bind(party)
    }
}
