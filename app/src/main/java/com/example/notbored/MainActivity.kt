package com.example.notbored

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.notbored.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        binding.btStart.setOnClickListener { val i = Intent(this, Activities::class.java)
        startActivity(i)}

        binding.tvTermsAndConditions.setOnClickListener {val i = Intent(this, TermAndConditions::class.java)
        startActivity(i)}

    }
}
