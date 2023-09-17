package com.example.calcr_hw2_pbm_4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Button
import android.widget.Toast

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


        fun complain(s: String): Boolean {
            Toast.makeText(
                this,
                s,
                Toast.LENGTH_SHORT
            ).show()
            result.setText("ERROR")
            return false
        }
        fun check(): Boolean {
            var good = false
            var n1string = n_1.text.toString()
            var n2string = n_2.text.toString()

            var i = 0
            for (c in n1string){
                if (c.equals('.')) i += 1
            }

            var j = 0
            for (c in n2string){
                if (c.equals('.')) j += 1
            }

            if (n1string.isEmpty() || n1string.isEmpty()) {
                complain("Please enter two values")
            }

            else if (i > 1 || n1string[0].equals('.') || n1string[n1string.length-1].equals('.') ) {
                complain("Please make a proper decimal")
            }
            else if (j > 1 || n2string[0].equals('.') || n2string[n2string.length-1].equals('.') ) {
                complain("Please make a proper decimal")
            }
            else if ((n2string.toInt() == 0) && (mode == "Div")) {
                complain("Cannot divide by 0")
            }
            else {
                good = true
            }

            return good



        }
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
            if (resultNum > 99999999) result.setText("MAX")
            else if (resultNum < -9999999) result.setText("MIN")
            else if (resultNum % 1 == 0.0) result.setText(resultNum.toInt().toString())
            else result.setText(resultNum.toString())





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
            var valid = check()
            if (valid) calculate()
        }

    }
}