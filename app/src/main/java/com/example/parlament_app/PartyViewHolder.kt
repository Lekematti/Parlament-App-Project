package com.example.parlament_app

import androidx.recyclerview.widget.RecyclerView
import com.example.parlament_app.databinding.FragmentPartiesBinding
import com.example.parlament_app.databinding.ItemPartiesBinding

class PartyViewHolder (private val view: ItemPartiesBinding) : RecyclerView.ViewHolder(view.root) {
        fun bind(party: String) {
            view.partyTextView.text = party
        }
    }
