package com.example.janiemogewiewiorkawscianie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var textBru = findViewById<TextView>(R.id.textView4)
        var textKMP = findViewById<TextView>(R.id.textView5)
        var textBM = findViewById<TextView>(R.id.textView6)
        var textRK = findViewById<TextView>(R.id.textView7)

        val btn = findViewById<Button>(R.id.button)

        fun bruteForce(text: String, wzorzec: String){
            val n = text.length
            val m = wzorzec.length
            for (i in 0..n-m) {
                var j = 0
                while (j < m && text[i + j] == wzorzec[j]) {
                    j++
                }
                if (j == m) {
                    return
                }
            }
        }

        fun KMP(ilra: Int) {
            var i = 0
            while (i < ilra) {

            }
        }

        fun BM(ilra: Int) {
            var i = 0
            while (i < ilra) {

            }
        }

        fun RK(ilra: Int) {
            var i = 0
            while (i < ilra) {

            }
        }

        btn.setOnClickListener {
            if (findViewById<EditText>(R.id.editTextNumber).text.toString() != "" && findViewById<EditText>(R.id.editTextNumber2).text.toString() != "" && findViewById<EditText>(R.id.editTextTextPersonName).text.toString() != "") {
                val ileraz = findViewById<EditText>(R.id.editTextNumber).text.toString().toInt()
                val iledan = findViewById<EditText>(R.id.editTextNumber2).text.toString().toInt()
                val wzor = findViewById<EditText>(R.id.editTextTextPersonName).text.toString()
            } else {
                Toast.makeText(this@MainActivity, "Uzupełnij wszystkie pola!", Toast.LENGTH_SHORT).show()
            }
        }

    }
}