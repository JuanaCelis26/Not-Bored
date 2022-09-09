package com.example.notbored.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.notbored.R

/**
 * The TermsAndCondition activity displays the Terms and Conditions and has a button to close the activity
 * It was decided to use findViewById because the buttonClose button is only used once
 **/


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