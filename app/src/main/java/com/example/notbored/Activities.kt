package com.example.notbored

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.notbored.AdapterActivities.AdapterActivities
import com.example.notbored.AdapterActivities.Interfaces.ClickItem
import com.example.notbored.databinding.ActivityActivitiesBinding

class Activities : AppCompatActivity(), ClickItem  {
    private lateinit var binding: ActivityActivitiesBinding
    private lateinit var adapter: AdapterActivities
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityActivitiesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val btnRandom = binding.btnRandom

        getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN);
        val listAtivities = listOf<String>("Education","Recreational","Social","Diy", "Charity","Cooking", "Relaxation","Music","BusyWork")

        adapter = AdapterActivities(listAtivities, this)
        binding.rvActivities.layoutManager = LinearLayoutManager(this)
        binding.rvActivities.adapter = adapter

        btnRandom.setOnClickListener {
            makeIntent("random")
        }

    }

    override fun clickItem(itemActivity: String) {
        makeIntent(itemActivity)
    }

    fun makeIntent (typeActivities : String) {
        var numParticipants = intent.getStringExtra("numParticipants")
       val irASuggestions = Intent (this, SuggestionsActivity::class.java)

        irASuggestions.putExtra("numParticipants",numParticipants.toString())
        irASuggestions.putExtra("typeActivities", typeActivities)
        startActivity(irASuggestions)

    }

}