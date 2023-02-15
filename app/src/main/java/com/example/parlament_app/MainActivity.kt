package com.example.parlament_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.parlament_app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var members: List<MemberOfParliament>
    private var randomMP: MemberOfParliament = MemberOfParliament(0, 0, "", "", "", false, "", "", 0, "")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        members = ParliamentMembersData.members
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.Pparties.text = "Parlament parties"

        fun showRandomMP() {
            randomMP = members
            binding.nameTextView.text = "${randomMP.first} ${randomMP.last}"
            binding.partyTextView.text = randomMP.party
            binding.pmImage.setImageResource(R.drawable.ic_launcher_foreground)
        }

        showRandomMP()

        binding.button1.setOnClickListener {
            showRandomMP()
        }
    }
}
