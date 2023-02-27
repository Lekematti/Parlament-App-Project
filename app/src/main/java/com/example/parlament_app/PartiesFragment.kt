package com.example.parlament_app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.parlament_app.databinding.FragmentHomeBinding
import com.example.parlament_app.databinding.FragmentPartiesBinding

class PartiesFragment : Fragment() {
    private lateinit var binding: FragmentPartiesBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding.recycleparties.setOnClickListener{
            findNavController().navigate(R.id.action_partiesFragment_to_membersFragment)
    }
        return binding.root
    }
}
