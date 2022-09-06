package com.example.notbored

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val termAndConditionsTv= findViewById<TextView>(R.id.tv_TermsAndConditions)
        termAndConditionsTv.setOnClickListener {
        val intent= Intent(this, TermAndConditions::class.java)
        startActivity(intent)
        }

    }
}
