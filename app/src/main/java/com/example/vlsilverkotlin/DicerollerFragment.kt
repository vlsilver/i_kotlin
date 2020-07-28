package com.example.vlsilverkotlin

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.view.*
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.getSystemService
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.vlsilverkotlin.databinding.DicerollerFragmentBinding

class DicerollerFragment : Fragment() {
    private var sum: Int = 0
    private var rd1: Int = 0
    private var rd2: Int = 0
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<DicerollerFragmentBinding>(
            inflater,
            R.layout.diceroller_fragment,
            container,
            false
        )
        binding.btRollSum2.setOnClickListener {
            if (binding.edt1.text.isNotEmpty()) {
                sum = binding.edt1.text.toString().toInt()
                if ((sum > 1) and (sum <= 12)) {
                    val m = getRandom()
                    binding.img1.setImageResource(m.first)
                    binding.img2.setImageResource(m.second)
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
            hideKeyboard()
        }
        binding.btRollRandom2.setOnClickListener {
            binding.img1.setImageResource(getIndex((1..6).random()))
            binding.img2.setImageResource(getIndex((1..6).random()))
            hideKeyboard()
        }
        setTilteActionbar()
        return binding.root
    }

    private fun setTilteActionbar() {
        (activity as AppCompatActivity).supportActionBar?.title = "Dice Roller"
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
        val toast: Toast = Toast.makeText(context, text, duration)
        toast.setGravity(triple.first, triple.second, triple.third)
        toast.show()
        val handler: Handler = Handler()
        handler.postDelayed(Runnable {
            fun run() {
                toast.cancel()
            }
        }, 100)
    }
    fun hideKeyboard(){
        val inputMethodManager = activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view?.windowToken, 0)
    }
}