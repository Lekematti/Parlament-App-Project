package com.example.parlament_app

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.parlament_app.databinding.ItemPartiesBinding

class PartiesAdapter(val parties: List<String>) : RecyclerView.Adapter<PartyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PartyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = ItemPartiesBinding.inflate(inflater, parent, false)
        return PartyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return parties.size
    }

    override fun onBindViewHolder(holder: PartyViewHolder, position: Int) {
        holder.itemView.findViewById<TextView>(R.id.party_text_view).apply {
            text = parties[position]
            setOnClickListener {
                val action = PartiesFragmentDirections.actionPartiesFragmentToMembersFragment()
                it.findNavController().navigate(action)
            }
        }
    }
}


