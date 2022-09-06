package com.example.notbored

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.LinearLayout
import android.widget.Toast

class Activities : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_activities)
        getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN);
        val llEducation  = findViewById<LinearLayout>(R.id.llEducation);
        val llRecreational  = findViewById<LinearLayout>(R.id.llRecreational);
        val llSocial  = findViewById<LinearLayout>(R.id.llSocial);
        val llDiy  = findViewById<LinearLayout>(R.id.llDiy);
        val llCharity = findViewById<LinearLayout>(R.id.llCharity);
        val llCooking  = findViewById<LinearLayout>(R.id.llCooking);
        val llRelaxation  = findViewById<LinearLayout>(R.id.llRelaxation);
        val llMusic = findViewById<LinearLayout>(R.id.llMusic);
        val llBusywork  = findViewById<LinearLayout>(R.id.llBusywork);

        llEducation.setOnClickListener {
            Toast.makeText(applicationContext,"Education",Toast.LENGTH_SHORT).show()
        }
        llRecreational.setOnClickListener {
            Toast.makeText(applicationContext,"Recreational",Toast.LENGTH_SHORT).show()
        }
        llSocial.setOnClickListener {
            Toast.makeText(applicationContext,"SOCIAL",Toast.LENGTH_SHORT).show()
        }
        llDiy.setOnClickListener {
            Toast.makeText(applicationContext,"DIY",Toast.LENGTH_SHORT).show()
        }
        llCharity.setOnClickListener {
            Toast.makeText(applicationContext,"CHARITY",Toast.LENGTH_SHORT).show()
        }
        llCooking.setOnClickListener {
            Toast.makeText(applicationContext,"COOKING",Toast.LENGTH_SHORT).show()
        }
        llRelaxation.setOnClickListener {
            Toast.makeText(applicationContext,"RELAXATION",Toast.LENGTH_SHORT).show()
        }
        llMusic.setOnClickListener {
            Toast.makeText(applicationContext,"MUSIC",Toast.LENGTH_SHORT).show()
        }
        llBusywork.setOnClickListener {
            Toast.makeText(applicationContext,"BUSYWORK",Toast.LENGTH_SHORT).show()
        }




    }

}