package com.example.vlsilverkotlin

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.vlsilverkotlin.databinding.AboutFragmentActivityBinding


class MainFragmentTitle : Fragment() {
    private var text:String = ""
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<AboutFragmentActivityBinding>(
            inflater,
            R.layout.about_fragment_activity,
            container,
            false
        )
        (activity as AppCompatActivity).supportActionBar?.title = "My App"
        return binding.root
    }

}
