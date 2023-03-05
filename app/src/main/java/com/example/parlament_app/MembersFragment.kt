package com.example.parlament_app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.parlament_app.databinding.FragmentMembersBinding


class MembersFragment : Fragment() {
    private lateinit var binding: FragmentMembersBinding
    private lateinit var viewModel: MemberActivityViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewModel = MemberActivityViewModel()
        binding = FragmentMembersBinding.inflate(layoutInflater)
        binding.membersrecycle.layoutManager = LinearLayoutManager(context)
        viewModel.members.observe(viewLifecycleOwner){
            binding.membersrecycle.adapter = MemberAdapter(it)
        }

        // Inflate the layout for this fragment
        return binding.root
    }
}
class MemberActivityViewModel: ViewModel() {
    //var member: MutableLiveData<List<MemberOfParliament>> = MutableLiveData()
    var members: LiveData<List<String>> = Transformations.map(ParlamentDatabase.getInstance().memberOfParliamentDAO.getAll()){
        it.map { "${it.firstname} ${it.lastname}" }.toSortedSet().toList()
    }
}