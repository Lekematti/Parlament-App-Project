// 15.2.2023
// Leo Koskimäki
// 2201352
// MembersFragment contains binding, viewModel and viewModelFactory
// for everything that is in fragment_members.xml
package com.example.parlament_app

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.parlament_app.databinding.FragmentMembersBinding

class MembersFragment : Fragment() {
    private lateinit var binding: FragmentMembersBinding
    private lateinit var viewModel: MemberActivityViewModel
    private lateinit var viewModelFactory: MemberActivityViewModelFactory
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val args = MembersFragmentArgs.fromBundle(requireArguments())
        Log.d("Hyvin toimii", args.party)
        viewModelFactory = MemberActivityViewModelFactory(args.party)
        viewModel = ViewModelProvider(this, viewModelFactory)[MemberActivityViewModel::class.java]
        binding = FragmentMembersBinding.inflate(layoutInflater)
        //layoutManager for membersrecycle that is used in fragment_members.xml
        binding.membersrecycle.layoutManager = LinearLayoutManager(context)
        viewModel.members.observe(viewLifecycleOwner){
            //membersrecycle getting the MemberAdapter
            binding.membersrecycle.adapter = MemberAdapter(it)
        }
        // Inflate the layout for this fragment
        return binding.root
    }
}
class MemberActivityViewModel(party: String): ViewModel() {
    //Getting a LiveData List from the PalamentRepository
    var members: LiveData<List<String>> = Transformations.map(ParlamentRepository.getMembers(party)){
        it.map {"${it.seatNumber}. ${it.firstname} ${it.lastname}: ${it.party}"}
    }
}
class MemberActivityViewModelFactory(private val party: String): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MemberActivityViewModel::class.java)) {
            return MemberActivityViewModel(party) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}