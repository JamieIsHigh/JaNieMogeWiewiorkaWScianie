package com.example.janiemogewiewiorkawscianie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random

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

        fun strGenerator(ildan: Int): String {
            val alphabet = "abcdefghijklmnopqrstuvwxyz"
            val lancuch = (1..ildan)
                .map { alphabet[Random.nextInt(alphabet.length)] }
                .joinToString("")
            return lancuch
        }

        btn.setOnClickListener {
            if (findViewById<EditText>(R.id.editTextNumber).text.toString() != "" && findViewById<EditText>(R.id.editTextNumber2).text.toString() != "" && findViewById<EditText>(R.id.editTextTextPersonName).text.toString() != "") {
                val ileraz = findViewById<EditText>(R.id.editTextNumber).text.toString().toInt()
                val iledan = findViewById<EditText>(R.id.editTextNumber2).text.toString().toInt()
                val wzor = findViewById<EditText>(R.id.editTextTextPersonName).text.toString()

                if (iledan < wzor.length) {
                    Toast.makeText(this@MainActivity, "Wzorzec nie może być dłuższy od tekstu!", Toast.LENGTH_LONG).show()
                }
                else {
                    val ster = strGenerator(iledan)
                    textRK.text = ster
                    var i = 0
                    while (i < ileraz) {
                        bruteForce(ster, wzor)
                        i++

                    }
                    Toast.makeText(this@MainActivity, "KONIEC", Toast.LENGTH_SHORT).show()
                    /* TU
                    * SIĘ
                    * BĘDZIE
                    * DZIAŁA
                    * MAGIA */
                }

            } else {
                Toast.makeText(this@MainActivity, "Uzupełnij wszystkie pola!", Toast.LENGTH_SHORT).show()
            }
        }

    }
}