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
import com.example.parlament_app.databinding.FragmentMembersBinding
import com.example.parlament_app.databinding.FragmentPartiesBinding

class MembersFragment : Fragment() {
    private lateinit var binding: FragmentMembersBinding
    private lateinit var viewModel: ThirdActivityViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ThirdActivityViewModel()
        binding = FragmentMembersBinding.inflate(layoutInflater)
        binding.membersrecycle.setOnClickListener{
            findNavController().navigate(R.id.action_membersFragment_to_memberInfoFragment)
            viewModel = ViewModelProvider(this).get(ThirdActivityViewModel::class.java)
        }
        binding.membersrecycle.layoutManager = LinearLayoutManager(context)
        viewModel.PMembers.observe(viewLifecycleOwner){
            binding.membersrecycle.adapter = MemberAdapter(it)
        }

        // Inflate the layout for this fragment
        return binding.root
    }
}
class ThirdActivityViewModel: ViewModel() {
    //var member: MutableLiveData<List<MemberOfParliament>> = MutableLiveData()
    var PMembers = Transformations.map(ParlamentDatabase.getInstance().memberOfParliamentDAO.getAll()){
        it.map { "${it.firstname} ${it.lastname}" }.toSortedSet().toList()
    }
}