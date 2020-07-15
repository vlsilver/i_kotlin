package com.example.diceroller1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import android.view.Gravity
import android.view.ScaleGestureDetector
import android.widget.ScrollView

class MainActivity : AppCompatActivity() {

    private var sum: Int = 0
    private var rd1: Int = 0
    private var rd2: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        supportActionBar?.hide()
        setContentView(R.layout.activity_main)
        bt_roll_folowsum.setOnClickListener {
            if (edt_1.text.isNotEmpty()) {
                sum = edt_1.text.toString().toInt()
                if ((sum > 1) and (sum <= 12)) {
                    val m = getRandom()
                    img_1.setImageResource(m.first)
                    img_2.setImageResource(m.second)
                } else {
                    showText(
                        "Sum of dices in range 2 to 12",
                        Toast.LENGTH_SHORT,
                        Triple(Gravity.CENTER, 0, 0)
                    )
                }
            } else {
                showText(
                    "Please fill in Sum of dices",
                    Toast.LENGTH_SHORT,
                    Triple(Gravity.CENTER, 0, 0)
                )
            }
        }
        bt_roll_random.setOnClickListener {
            img_1.setImageResource(getIndex((1..6).random()))
            img_2.setImageResource(getIndex((1..6).random()))
        }
        bt_back_2.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }
    }

    private fun getRandom(): Pair<Int, Int> {
        if (sum > 6) {
            rd1 = ((sum - 6)..6).random()
            rd2 = sum - rd1
        } else {
            rd1 = (1 until sum).random()
            rd2 = sum - rd1
        }
        rd1 = getIndex(rd1)
        rd2 = getIndex(rd2)
        return Pair(rd1, rd2)
    }

    private fun getIndex(rd: Int): Int {
        return when (rd) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
    }

    private fun showText(text: String, duration: Int, triple: Triple<Int, Int, Int>) {
        val toast: Toast = Toast.makeText(this, text, duration)
        toast.setGravity(triple.first, triple.second, triple.third)
        toast.show()
        val handler:Handler = Handler()
        handler.postDelayed(Runnable {
            fun run(){
                toast.cancel()
            }
        },100)
    }
}

