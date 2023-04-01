package com.example.janiemogewiewiorkawscianie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ileraz = findViewById<EditText>(R.id.editTextNumber).text.toString().toInt()
        val iledan = findViewById<EditText>(R.id.editTextNumber2).text.toString().toInt()

        var textBru = findViewById<TextView>(R.id.textView4)
        var textKMP = findViewById<TextView>(R.id.textView5)
        var textBM = findViewById<TextView>(R.id.textView6)
        var textRK = findViewById<TextView>(R.id.textView7)

        val btn = findViewById<Button>(R.id.button)

        fun bruteForce() {

        }

        fun KMP() {

        }

        fun BM() {

        }

        fun RK() {

        }

        btn.setOnClickListener {
            textBM.text = ileraz.toString()
        }

    }
}