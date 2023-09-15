package com.example.calcr_hw2_pbm_4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private lateinit var button_add: Button
    private lateinit var button_sub: Button
    private lateinit var button_mult: Button
    private lateinit var button_div: Button
    private lateinit var button_mod: Button
    private lateinit var button_enter: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        button_add = findViewById(R.id.add_button)
        button_sub = findViewById(R.id.sub_button)
        button_mult = findViewById(R.id.mult_button)
        button_div = findViewById(R.id.div_button)
        button_mod = findViewById(R.id.mod_button)
        button_enter = findViewById(R.id.button_enter)

        //text stuff
        var n_1 = findViewById<EditText>(R.id.n_1)
        var n_2 = findViewById<EditText>(R.id.n_2)
        var result = findViewById<TextView>(R.id.result)
        var resultNum = 0.0
        var mode = "None"

        fun calculate() {
            var number1 = n_1.getText().toString().toDouble()
            var number2 = n_2.getText().toString().toDouble()
            when (mode) {
                "Add" -> resultNum = number1 + number2
                "Sub" -> resultNum = number1 - number2
                "Mult" -> resultNum = number1 * number2
                "Div" -> resultNum = number1 / number2
                "Mod" -> resultNum = number1 % number2
            }
            if (resultNum % 1 == 0.0)
                result.setText(resultNum.toInt().toString())
            else
                result.setText(resultNum.toString())

        }

        button_add.setOnClickListener{
            mode = "Add"
        }
        button_sub.setOnClickListener{
            mode = "Sub"
        }
        button_mult.setOnClickListener{
            mode = "Mult"
        }
        button_div.setOnClickListener{
            mode = "Div"
        }
        button_mod.setOnClickListener{
            mode = "Mod"
        }
        button_enter.setOnClickListener{
            calculate()
        }

    }
}