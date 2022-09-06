package com.example.notbored

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
        getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN);

        val list = listOf<String>("Education","Recreational","Social","Diy", "Charity","Cooking", "Relaxation","Music","BusyWork")

        adapter = AdapterActivities(list, this)
        binding.rvActivities.layoutManager = LinearLayoutManager(this)
        binding.rvActivities.adapter = adapter

    }

    override fun clickItem(item: String) {
        Toast.makeText(this, item, Toast.LENGTH_SHORT).show()
    }

}