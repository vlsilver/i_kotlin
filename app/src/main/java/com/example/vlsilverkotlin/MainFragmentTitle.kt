package com.example.vlsilverkotlin

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.vlsilverkotlin.databinding.AboutFragmentTitleBinding


class MainFragmentTitle : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<AboutFragmentTitleBinding>(
            inflater,
            R.layout.about_fragment_title,
            container,
            false
        )
        (activity as AppCompatActivity).supportActionBar?.title = "My App"
        return binding.root
    }

}
