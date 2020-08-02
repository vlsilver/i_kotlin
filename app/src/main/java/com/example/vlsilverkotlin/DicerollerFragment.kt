package com.example.vlsilverkotlin

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.view.*
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.vlsilverkotlin.databinding.DicerollerFragmentBinding

const val KEY_DICEROLLER_IMG1 = "key_diceroller_img1"
const val KEY_DICEROLLER_IMG2 = "key_diceroller_img2"

class DicerollerFragment : Fragment() {
    private var sum = 0
    private var img1Id = dicerollerData.shuffled()[0].draw
    private var img2Id = dicerollerData.shuffled()[0].draw
    private lateinit var binding: DicerollerFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.diceroller_fragment,
            container,
            false
        )
        binding.img1.setBackgroundResource(img1Id)
        binding.img2.setBackgroundResource(img2Id)
        binding.btRollSum2.setOnClickListener {
            if (binding.edt1.text.isNotEmpty()) {
                sum = binding.edt1.text.toString().toInt()
                if ((sum >= 2*dicerollerData[0].num) and (sum <= 2*dicerollerData[(dicerollerData.size - 1)].num)) {
                    val dicerollerDataShuffled = dicerollerData.shuffled()
                    for (item1 in dicerollerDataShuffled) {
                        val num2 = sum - item1.num -1
                        if (num2 in (dicerollerDataShuffled.indices)) {
                            img1Id = item1.draw
                            img2Id = dicerollerData[num2].draw
                            binding.img1.setImageResource(img1Id)
                            binding.img2.setImageResource(img2Id)
                            break
                        }
                    }
                } else {
                    showText(
                        "Sum of dices in range 2 to 12", Triple(Gravity.CENTER, 0, 0)
                    )
                }
            } else {
                showText(
                    "Please fill in Sum of dices",
                    Triple(Gravity.CENTER, 0, 0)
                )
            }
            hideKeyboard()
        }
    binding.btRollRandom2.setOnClickListener()
    {
        img1Id = dicerollerData.shuffled()[0].draw
        img2Id = dicerollerData.shuffled()[0].draw
        binding.img1.setImageResource(img1Id)
        binding.img2.setImageResource(img2Id)
        hideKeyboard()
    }
    (activity as AppCompatActivity).supportActionBar?.title = "Dice Roller"
    return binding.root
}

override fun onSaveInstanceState(outState: Bundle) {
    super.onSaveInstanceState(outState)
    outState.putInt(KEY_DICEROLLER_IMG1, img1Id)
    outState.putInt(KEY_DICEROLLER_IMG2, img2Id)
}

override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    if (savedInstanceState != null) {
        img1Id = savedInstanceState.getInt(KEY_DICEROLLER_IMG1, 1)
        img2Id = savedInstanceState.getInt(KEY_DICEROLLER_IMG2, 1)
    }
}


private fun showText(text: String, triple: Triple<Int, Int, Int>) {
    val toast: Toast = Toast.makeText(context, text, Toast.LENGTH_SHORT)
    toast.setGravity(triple.first, triple.second, triple.third)
    toast.show()
    val handler = Handler()
    handler.postDelayed({
    }, 100)
}

private fun hideKeyboard() {
    val inputMethodManager =
        activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.hideSoftInputFromWindow(view?.windowToken, 0)
}
}