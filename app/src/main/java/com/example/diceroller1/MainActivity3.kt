package com.example.diceroller1

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main3.*

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)
        supportActionBar?.hide()
        bt_next_3.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        bt_back_3.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }
        setListeners()
        bt_setall_3.setOnClickListener {
            for (item in listOf(
                    box_one_text_3, box_two_text_3,
                    box_three_text_3, box_four_text_3, box_five_text_3))
            { makeColored(item) }
        }
        bt_reset_3.setOnClickListener {
            val intent = Intent(this, MainActivity3::class.java)
            startActivity(intent)
        }
    }
    private fun makeColored(textView: TextView) {
            textView.setBackgroundColor(Color.BLACK)
            textView.setTextColor(Color.WHITE)
    }
    private fun setListeners(){
        val clickableViews: List<TextView> = listOf(box_one_text_3, box_two_text_3,
            box_three_text_3, box_four_text_3, box_five_text_3)
        for (item in clickableViews){
            item.setOnClickListener{
                makeColored(item)
            }
        }

    }
    }