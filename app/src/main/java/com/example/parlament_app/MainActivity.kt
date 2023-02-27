package com.example.parlament_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.parlament_app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var members: List<MemberOfParliament>
    private lateinit var navController: NavController
    private var randomMP: MemberOfParliament = MemberOfParliament(0, 0, "", "", "", false, "", "", 0, "")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        members = ParliamentMembersData.members
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navController = navHostFragment.navController

        /*binding.Bparties.text = "Parlament parties"


        fun showRandomMP() {
            randomMP = members
            binding.nameTextView.text = "${randomMP.first} ${randomMP.last}"
            binding.partyTextView.text = randomMP.party
            binding.pmImage.setImageResource(R.drawable.ic_launcher_foreground)
            binding.recycleparties.text = randomMP.party
        }

        showRandomMP()

        binding.Bparties.setOnClickListener {
            showRandomMP()
        }*/
    }
}
