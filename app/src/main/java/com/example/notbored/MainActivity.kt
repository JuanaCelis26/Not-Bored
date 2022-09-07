package com.example.notbored

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.notbored.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val etParticipantsNum = binding.etNumberParticipants
        val btnStart = binding.btStart

        btnStart.setOnClickListener {
            var number = etParticipantsNum.text.toString()
            if(etParticipantsNum.text.isEmpty() || etParticipantsNum.text.equals("0") ){
                val random = (0..8).random()
                number = random.toString()
            }

            val i = Intent(this, Activities::class.java)
            i.putExtra("numParticipants", number)
            startActivity(i)
        }

        binding.tvTermsAndConditions.setOnClickListener {val i = Intent(this, TermAndConditions::class.java)
        startActivity(i)}

    }
}
