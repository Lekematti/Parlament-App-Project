package com.example.parlament_app

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.parlament_app.databinding.ItemPartiesBinding

class PartiesAdapter : RecyclerView.Adapter<PartyViewHolder>() {
    private val members = ParliamentMembersData.members

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PartyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = ItemPartiesBinding.inflate(inflater, parent, false)
        return PartyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return members.size
    }

    override fun onBindViewHolder(holder: PartyViewHolder, position: Int) {
        val member = members[position]
        holder.bind(member)
    }
}
