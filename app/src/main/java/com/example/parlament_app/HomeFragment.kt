// 15.2.2023
// Leo Koskimäki
// 2201352
// HomeFragment contains binding and ViewModel
// for everything that is in fragment_home.xml
// and some other stuff.
package com.example.parlament_app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        viewModel = MainActivityViewModel()

        //Text for the buttons on the home screen
        binding.Bparties.text = "Parties"
        binding.BMemberList.text = "Member list"
        binding.HomeTextView.text = "Finnish Parliament App"

        // A OnClickListener for the Parties button. Used for moving to the Parties Fragment
        binding.Bparties.setOnClickListener{
            findNavController().navigate(R.id.action_homeFragment_to_partiesFragment)
            viewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]
        }
        // A OnClickListener for the Member list button. Used for moving to the MemberList Fragment
        binding.BMemberList.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_memberListFragment)
            viewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]
        }
        // Inflate the layout for this fragment
        return binding.root
    }

    //The viewModel.readMembers() is for getting the data when first opening the app or if the data is wiped
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.readMembers()
        viewModel.member.observe(viewLifecycleOwner) {
            println("member changed")
        }
    }
}
class MainActivityViewModel: ViewModel() {
    // gets a list from ParliamentDAO.kt. List is MutableLiveData
    var member: MutableLiveData<List<MemberOfParliament>> = MutableLiveData()

    // function readMembers is used to get data. It gets it from the API and database
    fun readMembers() {
        viewModelScope.launch {
            try {
                val dao = ParlamentDatabase.getInstance().memberOfParliamentDAO
                member.value = ParlamentApi.retrofitService.getParlamentList()
                println("Read members from parliament with great success.")
                member.value?.forEach {
                    dao.insert(it)
                }
                println("Members written to database")
            } catch (e: Exception) {
                println("No luck in reading members from parliament: $e")
            }
        }
    }
}