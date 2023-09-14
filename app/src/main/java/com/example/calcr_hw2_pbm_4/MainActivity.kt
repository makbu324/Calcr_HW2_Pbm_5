package com.example.calcr_hw2_pbm_4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //text stuff
        var n_1 = findViewById<EditText>(R.id.n_1)
        var n_2 = findViewById<EditText>(R.id.n_2)
        var result = findViewById<TextView>(R.id.result)
    }
}