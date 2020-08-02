package com.example.vlsilverkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.vlsilverkotlin.databinding.MyimageFragmentBinding

const val KEY_IMGID = "key_imgid"

class MyimageFragment : Fragment() {
    private var imgId: Int = myImageData.shuffled()[0].draw
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
        binding.boxTwoText3.setImageResource(imgId)
        binding.boxTwoText3.setOnClickListener {
            imgId = myImageData.shuffled()[0].draw
            binding.boxTwoText3.setImageResource(imgId)
        }
        (activity as AppCompatActivity).supportActionBar?.title = "My Image"
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState != null) {
            imgId = savedInstanceState.getInt(KEY_IMGID, imgId)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(KEY_IMGID, imgId)
    }
}