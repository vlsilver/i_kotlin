package com.example.diceroller1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var sum:Int = 0
    private var rd1:Int = 0
    private var rd2:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)
        supportActionBar?.hide()
        setContentView(R.layout.activity_main)
        bt_roll.setOnClickListener{
            sum = (2 .. 12).random()
            val m = getRandom()
            img_1.setImageResource(m.first)
            img_2.setImageResource(m.second)
            Toast.makeText(this, "SUM OF DICE: $sum", Toast.LENGTH_SHORT).show()
        }
        bt_reset.setOnClickListener{
            img_1.setImageResource(R.drawable.ic_launcher_foreground)
            img_2.setImageResource(R.drawable.ic_launcher_foreground)
        }
    }

    private fun getRandom():Pair<Int, Int>{
        if (sum>6) {
            rd1 = ((sum - 6) .. 6).random()
            rd2 = sum - rd1
        }
        else{
            rd1 = (1 until sum).random()
            rd2 = sum - rd1
        }
        rd1 = getIndex(rd1)
        rd2 = getIndex(rd2)
        return Pair(rd1, rd2)
    }
    private fun getIndex(rd:Int):Int {
        return when (rd) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
    }
}
