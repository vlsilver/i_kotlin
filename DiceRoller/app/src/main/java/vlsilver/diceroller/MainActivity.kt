package vlsilver.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private var m: String = "0"
    private lateinit var imgDice1: ImageView
    private lateinit var imgDice2: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        setSupportActionBar(findViewById(R.id.tb_toolbar))
        val btnRoll:Button = findViewById(R.id.btn_roll)
        val btnReset:Button = findViewById(R.id.btn_reset)
        imgDice1 = findViewById(R.id.img_dice_1)
        imgDice2 = findViewById(R.id.img_dice_2)
        btnRoll.setOnClickListener {
            imgDice1.setImageResource(getRandomDiceImage())
            imgDice2.setImageResource(getRandomDiceImage())
            Toast.makeText(this,"SUM NUMBER OF DICE: $m",Toast.LENGTH_SHORT).show()
            m = "0"
        }
        btnReset.setOnClickListener{ reSet() }
    }
//  hide status bar
    override fun onWindowFocusChanged(hasFocus: Boolean) {
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        super.onWindowFocusChanged(hasFocus)
    }

    private fun getRandomDiceImage():Int{
        val randomInt = (1..6).random()
        m = (m.toInt() + randomInt).toString()
        return when (randomInt) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
    }

    private fun reSet(){
        imgDice1.setImageResource(R.drawable.empty_dice)
        imgDice2.setImageResource(R.drawable.empty_dice)
        Toast.makeText(this,"RESET",Toast.LENGTH_SHORT).show()
        m = "0"
    }

}


