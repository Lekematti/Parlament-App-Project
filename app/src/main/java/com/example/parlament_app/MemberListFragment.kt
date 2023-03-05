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
import com.example.parlament_app.databinding.FragmentMemberListBinding


class MemberListFragment : Fragment() {
    private lateinit var binding: FragmentMemberListBinding
    private lateinit var viewModel: MemberListActivityViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewModel = MemberListActivityViewModel()
        binding = FragmentMemberListBinding.inflate(layoutInflater)
        binding.RecycleMemberList.layoutManager = LinearLayoutManager(context)
        viewModel.members.observe(viewLifecycleOwner){
            binding.RecycleMemberList.adapter = MemberListAdapter(it)
        }

        // Inflate the layout for this fragment
        return binding.root
    }
}
class MemberListActivityViewModel: ViewModel() {
    //var member: MutableLiveData<List<MemberOfParliament>> = MutableLiveData()
    var members: LiveData<List<String>> = Transformations.map(ParlamentDatabase.getInstance().memberOfParliamentDAO.getAll()){
        it.map {"${it.firstname} ${it.lastname} Party: ${it.party}" }.toSortedSet().toList()
    }
}