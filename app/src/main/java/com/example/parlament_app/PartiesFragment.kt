package com.example.parlament_app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.parlament_app.databinding.FragmentPartiesBinding
import kotlinx.coroutines.launch

class PartiesFragment : Fragment() {
    private lateinit var binding: FragmentPartiesBinding
    private lateinit var viewModel: SecondActivityViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = SecondActivityViewModel()
        binding = FragmentPartiesBinding.inflate(layoutInflater)
        binding.recycleparties.setOnClickListener{
            findNavController().navigate(R.id.action_partiesFragment_to_membersFragment)
            viewModel = ViewModelProvider(this).get(SecondActivityViewModel::class.java)
    }
        binding.recycleparties.layoutManager = LinearLayoutManager(context)
        viewModel.parties.observe(viewLifecycleOwner){
            binding.recycleparties.adapter = PartiesAdapter(it)
        }

        return binding.root
    }
}
class SecondActivityViewModel: ViewModel() {
    var member: MutableLiveData<List<MemberOfParliament>> = MutableLiveData()
    var parties = Transformations.map(ParlamentDatabase.getInstance().memberOfParliamentDAO.getAll()){
        it.map { it.party }.toSortedSet().toList()
    }
}