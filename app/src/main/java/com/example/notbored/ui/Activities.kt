package com.example.notbored.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.notbored.AdapterActivities.AdapterActivities
import com.example.notbored.Interfaces.ClickItem
import com.example.notbored.databinding.ActivityActivitiesBinding

/**
 * This activity shows the types available to query, this is stored in listActivities. the user can select a type or choose the random option
 * To show the different types of activities, an adapter (adapter) and a recyclerview (rvActivities) where the list of activities listActivities is shown
 * Additionally, the ClickItem interface was implemented, which has the clickItem method, which receives the type of activity from the adapter.
 **/
class Activities : AppCompatActivity(), ClickItem  {
    private lateinit var binding: ActivityActivitiesBinding
    private lateinit var adapter: AdapterActivities
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityActivitiesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val btnRandom = binding.btnRandom
        val rvActivities = binding.rvActivities
        getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN);

        val listActivities = listOf<String>("Education","Recreational","Social","Diy", "Charity","Cooking", "Relaxation","Music","BusyWork")
        adapter = AdapterActivities(listActivities, this)
        rvActivities.layoutManager = LinearLayoutManager(this)
        rvActivities.adapter = adapter

        btnRandom.setOnClickListener {
            makeIntent("random")
        }

    }

    override fun clickItem(itemActivity: String) {
        makeIntent(itemActivity)
    }

    /**
     * The makeIntent method is called when the user selects an activity or chooses the random option.
     **/
    fun makeIntent (typeActivities : String) {
        var numParticipants = intent.getStringExtra("numParticipants")
        val irASuggestions = Intent (this, SuggestionsActivity::class.java)

        irASuggestions.putExtra("numParticipants",numParticipants.toString())
        irASuggestions.putExtra("typeActivities", typeActivities)
        startActivity(irASuggestions)

    }

}