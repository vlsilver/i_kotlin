package com.example.vlsilverkotlin.guessthword.score

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import com.example.vlsilverkotlin.R
import com.example.vlsilverkotlin.databinding.GuessthewordFragmentScoreBinding

class GuessthewordFragmentScore : Fragment() {
    private lateinit var viewModel: ViewModelGuessthewordFragmentScore
    private lateinit var viewModelFactory: FactoryViewModelGuessthewordFragmentScore
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<GuessthewordFragmentScoreBinding>(
            inflater,
            R.layout.guesstheword_fragment_score,
            container,
            false
        )
        viewModelFactory = FactoryViewModelGuessthewordFragmentScore(
            GuessthewordFragmentScoreArgs.fromBundle(requireArguments()).score
        )
        viewModel = ViewModelProvider(
            this,
            viewModelFactory
        ).get(ViewModelGuessthewordFragmentScore::class.java)
        binding.scoreViewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
//        viewModel.score.observe(viewLifecycleOwner, Observer { newScore ->
//            binding.scoreText.text = newScore.toString()
//        })
        viewModel.eventPlayAgain.observe(viewLifecycleOwner, Observer { newEventPlayAgain ->
            if(newEventPlayAgain == true) {
                NavHostFragment.findNavController(this).navigate(GuessthewordFragmentScoreDirections.actionGuessthewordFragmentScoreToGuessthewordFragmentTitle())
//                viewModel.playAgaintComplete()
            }
        })
//        binding.playAgainButton.setOnClickListener { viewModel.playAgaint() }
////        val score =
//            GuessthewordFragmentScoreArgs.fromBundle(requireArguments()).score.toString()
//        binding.scoreText.text = score.toString()
        return binding.root
    }
}