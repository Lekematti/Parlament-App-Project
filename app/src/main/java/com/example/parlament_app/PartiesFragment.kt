package com.example.parlament_app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.parlament_app.databinding.FragmentPartiesBinding

class PartiesFragment : Fragment() {
    private lateinit var binding: FragmentPartiesBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPartiesBinding.inflate(layoutInflater)
        binding.recycleparties.setOnClickListener{
            findNavController().navigate(R.id.action_partiesFragment_to_membersFragment)
    }
        binding.recycleparties.layoutManager = LinearLayoutManager(context)
        binding.recycleparties.adapter = PartiesAdapter()
        return binding.root
    }
}
