package com.example.diceroller1

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import kotlinx.android.synthetic.main.activity_main2.*
import org.w3c.dom.Text

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)
        supportActionBar?.hide()
        bt_next_2.setOnClickListener {
            val intent = Intent(this, MainActivity3::class.java)
            startActivity(intent)
        }
        bt_done.setOnClickListener {
            addNickname(bt_done)
        }
        bt_back_2.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }
        nickname_text.setOnClickListener{
            updateNickname(it)
        }
    }
    private fun addNickname(view: View){
        txt_name1.text = edt_2.text
        nickname_text.text = edt_2.text
//        Hide DONE Button and edittext
        edt_2.visibility = View.GONE
        view.visibility = View.GONE
        nickname_text.visibility = View.VISIBLE
//        Hide keyboard
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }
    private fun updateNickname(view:View){
        edt_2.visibility = View.VISIBLE
        bt_done.visibility = View.VISIBLE
        view.visibility = View.GONE
        edt_2.requestFocus()

    }
}