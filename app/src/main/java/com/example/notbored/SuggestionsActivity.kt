package com.example.notbored

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class SuggestionsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_suggestions)
        val numParticipants = intent.getStringExtra("numParticipants")
        val typeActivities = intent.getStringExtra("typeActivities")
    }
}