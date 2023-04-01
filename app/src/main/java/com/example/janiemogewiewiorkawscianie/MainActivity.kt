package com.example.janiemogewiewiorkawscianie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ileraz = findViewById<EditText>(R.id.editTextNumber).text.toString().toInt()
        val iledan = findViewById<EditText>(R.id.editTextNumber2).text.toString().toInt()

        val textBru = findViewById<TextView>(R.id.textView4).text
        val textKMP = findViewById<TextView>(R.id.textView5).text
        val textBM = findViewById<TextView>(R.id.textView6).text
        val textRK = findViewById<TextView>(R.id.textView7).text
    }
}