package com.example.notbored.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.notbored.databinding.ActivityMainBinding

/**
 * This activity accesses the terms and conditions screen and the activities screen, with btnStart and tvTermsAndConditions.
 **/

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val etParticipantsNum = binding.etNumberParticipants
        val btnStart = binding.btStart
        val tvTermAndConditions = binding.tvTermsAndConditions
/**
 * In addition, this activity receives the number of participants entered by the user and stores it in the var numParticipants
 **/
        btnStart.setOnClickListener {
            var numParticipants = etParticipantsNum.text.toString()
            if(etParticipantsNum.text.isEmpty() || etParticipantsNum.text.equals("0") ){
                numParticipants = "0"
            }

            val i = Intent(this, Activities::class.java)
            i.putExtra("numParticipants", numParticipants)
            startActivity(i)
        }

        tvTermAndConditions.setOnClickListener {val i = Intent(this, TermAndConditions::class.java)
        startActivity(i)}

    }
}
