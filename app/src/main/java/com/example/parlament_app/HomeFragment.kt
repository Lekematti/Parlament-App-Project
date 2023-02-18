package com.example.parlament_app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController


class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)

        binding.button.setOnClickListener{
            val action = FragmentOneDirections.actionFragmentOneToFragmentTwo()
            findNavController().navigate(action)
        }
        return binding.root
    }
}