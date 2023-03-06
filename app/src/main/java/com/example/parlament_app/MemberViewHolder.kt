package com.example.parlament_app

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.parlament_app.databinding.ItemMemberBinding
import com.example.parlament_app.databinding.ItemPartiesBinding

class MemberViewHolder(private val view: ItemMemberBinding) : RecyclerView.ViewHolder(view.root) {
        val image: ImageView = view.PMImage
    }
