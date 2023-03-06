// 27.2.2023
// Leo Koskimäki
// 2201352
// An adapter for the recycleView
// that is used in the PartiesFragment
package com.example.parlament_app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView

class PartiesAdapter(private val parties: List<String>) : RecyclerView.Adapter<PartiesAdapter.PartiesViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PartiesViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_parties, parent, false)
            return PartiesViewHolder(view)
        }
        override fun getItemCount(): Int {
            return parties.size
        }

        // ViewHolder for the text view that is in item_parties.xml
        override fun onBindViewHolder(holder: PartiesViewHolder, position: Int) {
            holder.itemView.findViewById<TextView>(R.id.party_text_view).apply {
                text = parties[position]
                val party = text.toString()
                // OnClickListener for moving to the MembersFragment
                setOnClickListener {
                    val action = PartiesFragmentDirections.actionPartiesFragmentToMembersFragment(party)
                    it.findNavController().navigate(action)
                }
            }
        }
        class PartiesViewHolder(view: View) : RecyclerView.ViewHolder(view)
}
