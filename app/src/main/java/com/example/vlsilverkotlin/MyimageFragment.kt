package com.example.vlsilverkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.vlsilverkotlin.databinding.MyimageFragmentBinding

class MyimageFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<MyimageFragmentBinding>(
            inflater,
            R.layout.myimage_fragment,
            container,
            false
        )
        val clickableViews: List<TextView> = listOf(
            binding.boxFiveText3,
            binding.boxFourText3,
            binding.boxSevenText3,
            binding.boxSixText3,
            binding.boxThreeText3,
            binding.boxTwoText3
        )
        for (item in clickableViews) {
            item.setOnClickListener {
                val idex: Int = (0..9).random()
                item.setBackgroundResource(mymy[idex].draw)
                item.text = mymy[idex].location
            }
        }
        setTilteActionbar()
        return binding.root
    }
    private fun setTilteActionbar() {
        (activity as AppCompatActivity).supportActionBar?.title = "My Image"
    }
}