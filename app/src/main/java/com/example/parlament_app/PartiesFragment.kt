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
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.parlament_app.databinding.FragmentPartiesBinding


class PartiesFragment : Fragment() {
    private lateinit var binding: FragmentPartiesBinding
    private lateinit var viewModel: PartiesActivityViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewModel = PartiesActivityViewModel()
        binding = FragmentPartiesBinding.inflate(layoutInflater)
        binding.recycleparties.setOnClickListener{
            findNavController().navigate(R.id.action_partiesFragment_to_membersFragment)
            viewModel = ViewModelProvider(this).get(PartiesActivityViewModel::class.java)
        }
        binding.recycleparties.layoutManager = LinearLayoutManager(context)
        viewModel.parties.observe(viewLifecycleOwner){
            binding.recycleparties.adapter = PartiesAdapter(it)
        }

        return binding.root
    }
}
class PartiesActivityViewModel: ViewModel() {
    var member: MutableLiveData<List<MemberOfParliament>> = MutableLiveData()
    var parties = Transformations.map(ParlamentDatabase.getInstance().memberOfParliamentDAO.getAll()){
        it.map { it.party }.toSortedSet().toList()
    }
}