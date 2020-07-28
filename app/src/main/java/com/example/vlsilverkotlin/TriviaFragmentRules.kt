package com.example.android.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedDispatcher
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentManager
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.vlsilverkotlin.R
import com.example.vlsilverkotlin.databinding.TriviaFragmentRulesBinding

class TriviaFragmentRules : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<TriviaFragmentRulesBinding>(
            inflater,
            R.layout.trivia_fragment_rules,
            container,
            false
        )

        setTilteActionbar()
        binding.playButton.setOnClickListener {
            it.findNavController()
                .navigate(R.id.action_triviaFragmentRules_to_triviaFragmentGame)
        }
        return binding.root
    }

    private fun setTilteActionbar() {
        (activity as AppCompatActivity).supportActionBar?.title = "Trivia"
    }
}
