package com.example.parlament_app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.navigation.fragment.findNavController
import com.example.parlament_app.databinding.FragmentHomeBinding
import kotlinx.coroutines.launch


class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var viewModel: MainActivityViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        viewModel = MainActivityViewModel()
        // Inflate the layout for this fragment
        binding.Bparties.setOnClickListener{
            findNavController().navigate(R.id.action_homeFragment_to_partiesFragment)
            viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        }

        binding.button.setOnClickListener {
            viewModel.readMembers()
        }
        viewModel.member.observe(viewLifecycleOwner) {
            println("players changed!!!")
            binding.textView.text = it.joinToString(", ")
        }

        return binding.root
    }
}
class MainActivityViewModel: ViewModel() {
    var member: MutableLiveData<List<MemberOfParliament>> = MutableLiveData()

    fun readMembers() {
        viewModelScope.launch {
            try {
                member.value = ParlamentApi.retrofitService.getParlamentList()
                println("Read members from parlament with great success.")
            } catch (e: Exception) {
                println("No luck in reading members from parlament: ${e}")
            }
        }
    }
}