package com.example.vlsilverkotlin

import android.os.Bundle
import android.view.*
import androidx.core.graphics.component1
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.navigation.fragment.findNavController
import com.example.vlsilverkotlin.R.*
import com.example.vlsilverkotlin.databinding.AboutFragmentTitleBinding
import com.google.android.material.internal.NavigationMenu
import com.google.android.material.internal.NavigationMenuItemView
import com.google.android.material.internal.NavigationMenuView
import kotlinx.android.synthetic.main.activity_main.*

class AboutFragmentTitle : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<AboutFragmentTitleBinding>(
            inflater,
            layout.about_fragment_title,
            container,
            false
        )
        return binding.root
    }

}
