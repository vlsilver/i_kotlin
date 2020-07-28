package com.example.vlsilverkotlin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.vlsilverkotlin.databinding.TriviaFragmentGameoverBinding

class TriviaFragmentGameover : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<TriviaFragmentGameoverBinding>(
            inflater, R.layout.trivia_fragment_gameover, container, false
        )
        binding.tryAgainButton.setOnClickListener {
            it.findNavController().navigate(R.id.action_triviaFragmentGameover_to_triviaFragmentGame)
        }
        setTilteActionbar()
        return binding.root
    }
    private fun setTilteActionbar() {
        (activity as AppCompatActivity).supportActionBar?.title = "Trivia"
    }
}


