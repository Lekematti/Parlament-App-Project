package com.example.parlament_app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.parlament_app.databinding.ActivityMainBinding
import com.example.parlament_app.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    private lateinit var DataBindingUtil: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)

        binding.Bparties.setOnClickListener{
            val action = FragmentOneDirections.actionHomeFragmentToPartiesFragment()
            findNavController().navigate(action)
        }
        return binding.root
    }
}