package com.example.janiemogewiewiorkawscianie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textBru = findViewById<TextView>(R.id.textView4)
        val textKMP = findViewById<TextView>(R.id.textView5)
        val textBM = findViewById<TextView>(R.id.textView6)
        val textRK = findViewById<TextView>(R.id.textView7)
        val textBol = findViewById<TextView>(R.id.textView9)

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
                    textBol.text = "TAK"
                    return
                }
            }
            textBol.text = "NIE"
        }

        fun prefi(wzorzec: String): IntArray {
            val m = wzorzec.length
            val lps = IntArray(m)
            var l = 0
            var i = 1

            while (i < m) {
                when {
                    wzorzec[i] == wzorzec[l] -> {
                        l++
                        lps[i] = l
                        i++
                    }
                    l > 0 -> l = lps[l - 1]
                    else -> {
                        lps[i] = 0
                        i++
                    }
                }
            }

            return lps
        }

        fun KMP(text: String, wzorzec: String) {
                val n = text.length
                val m = wzorzec.length
                val lps = prefi(wzorzec)

                var i = 0
                var j = 0
                while (i < n) {
                    when {
                        wzorzec[j] == text[i] -> {
                            i++
                            j++
                        }
                        j > 0 -> j = lps[j - 1]
                        else -> i++
                    }

                    if (j == m) {
                        return
                    }
                }
            }



        fun BM(text: String, wzorzec: String) {
            val n = text.length
            val m = wzorzec.length
            val b = IntArray(256) { -1 }
            for (i in 0 until m) {
                b[wzorzec[i].toInt()] = i
            }

            var i = m - 1
            var j = m - 1
            while (i < n) {
                if (text[i] == wzorzec[j]) {
                    if (j == 0) {
                        return
                    }
                    i--
                    j--
                } else {
                    i += m - java.lang.Math.min(j, 1 + b[text[i].toInt()])
                    j = m - 1
                }
            }
        }

        fun RK(text: String, wzorzec: String) {
            val pri = 101
            val n = text.length
            val m = wzorzec.length
            val patternHash = wzorzec.hashCode()
            var textHash = 0
            for (i in 0 until m) {
                textHash += (text[i].toInt() * pri.toDouble().pow(m - i - 1).toInt())
            }

            for (i in 0..n - m) {
                if (textHash == patternHash && text.substring(i, i + m) == wzorzec) {
                    return
                }
                if (i < n - m) {
                    textHash = (textHash - (text[i].toInt() * pri.toDouble().pow(m - 1).toInt()))
                    textHash = textHash * pri + text[i + m].toInt()
                }
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
                    var i = 0
                    var czStart: Long = 0
                    var czStop: Long = 1
                    var total: Long = 0
                    czStart = System.currentTimeMillis()
                    while (i < ileraz) {
                        bruteForce(ster, wzor)
                        i++
                    }
                    czStop = System.currentTimeMillis()
                    total = czStop-czStart
                    textBru.text = "Bruteforce: " + total.toString() + " ms"

                    i = 0
                    czStart = System.currentTimeMillis()
                    while (i < ileraz) {
                        KMP(ster, wzor)
                        i++
                    }
                    czStop = System.currentTimeMillis()
                    total = czStop-czStart
                    textKMP.text = "Knutha-Morrisa-Patta: " + total.toString() + " ms"

                    i = 0
                    czStart = System.currentTimeMillis()
                    while (i < ileraz) {
                        BM(ster, wzor)
                        i++
                    }
                    czStop = System.currentTimeMillis()
                    total = czStop-czStart
                    textBM.text = "Boyera-Moorea: " + total.toString() + " ms"

                    i = 0
                    czStart = System.currentTimeMillis()
                    while (i < ileraz) {
                        RK(ster, wzor)
                        i++
                    }
                    czStop = System.currentTimeMillis()
                    total = czStop-czStart
                    textRK.text = "Rabina-Karpa: " + total.toString() + " ms"

                    Toast.makeText(this@MainActivity, "KONIEC", Toast.LENGTH_SHORT).show()
                }

            } else {
                Toast.makeText(this@MainActivity, "Uzupełnij wszystkie pola!", Toast.LENGTH_SHORT).show()
            }
        }

    }
}