// 5.3.2023
// Leo Koskimäki
// 2201352
// An adapter for the recycleView
// that is used in the MemberListFragment
package com.example.parlament_app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MemberListAdapter (private val members: List<String>) : RecyclerView.Adapter<MemberListAdapter.MemberListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemberListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_member_list,parent,false)
        return MemberListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return members.size
    }

    // ViewHolder for the text view that is in item_member_list.xml
    override fun onBindViewHolder(holder: MemberListViewHolder, position: Int) {
        holder.itemView.findViewById<TextView>(R.id.MemberListTextView).apply {
            text = members[position]
        }

    }
    class MemberListViewHolder (view: View) : RecyclerView.ViewHolder(view)
}
