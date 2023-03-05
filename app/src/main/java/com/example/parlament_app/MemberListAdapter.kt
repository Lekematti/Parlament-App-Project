package com.example.parlament_app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MemberListAdapter (val members: List<String>) : RecyclerView.Adapter<MemberListAdapter.MemberListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemberListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_member_list,parent,false)
        return MemberListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return members.size
    }

    override fun onBindViewHolder(holder: MemberListViewHolder, position: Int) {
        holder.itemView.findViewById<TextView>(R.id.MemberListTextView).apply {
            text = members[position]
        }

    }
    class MemberListViewHolder (view: View) : RecyclerView.ViewHolder(view) {

    }
}
