package com.example.vlsilverkotlin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.vlsilverkotlin.databinding.TriviaFragmentGamewonBinding

class TriviaFragmentGamewon:Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<TriviaFragmentGamewonBinding>(
            inflater, R.layout.trivia_fragment_gamewon, container, false
        )
        binding.nextMatchButton.setOnClickListener {
            it.findNavController().navigate(R.id.action_triviaFragmentGamewon_to_triviaFragmentGame)
        }
        setTilteActionbar()
        return binding.root
    }
    private fun setTilteActionbar() {
        (activity as AppCompatActivity).supportActionBar?.title = "Trivia"
    }
}