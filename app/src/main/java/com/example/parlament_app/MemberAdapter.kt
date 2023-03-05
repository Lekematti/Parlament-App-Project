package com.example.parlament_app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView

class MemberAdapter (val members: List<String>) : RecyclerView.Adapter<MemberAdapter.MemberViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemberViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_member,parent,false)
        return MemberViewHolder(view)
    }

    override fun getItemCount(): Int {
        return members.size
    }

    override fun onBindViewHolder(holder: MemberViewHolder, position: Int) {
        holder.itemView.findViewById<TextView>(R.id.member_text_view).apply {
            text = members[position]
            setOnClickListener {
                val action = MembersFragmentDirections.actionMembersFragmentToPartiesFragment()
                it.findNavController().navigate(action)
            }
        }
    }
    class MemberViewHolder (view: View) : RecyclerView.ViewHolder(view) {
    }
}
