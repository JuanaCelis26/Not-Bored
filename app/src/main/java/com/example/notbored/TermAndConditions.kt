package com.example.notbored

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button


class TermAndConditions : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_terms_and_conditions)

        val buttonClose = findViewById<Button>(R.id.bt_close)
        buttonClose.setOnClickListener {
            finish()
        }
    }
}