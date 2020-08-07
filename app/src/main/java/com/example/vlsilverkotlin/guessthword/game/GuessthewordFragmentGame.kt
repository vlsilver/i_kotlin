package com.example.vlsilverkotlin.guessthword.game

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import com.example.vlsilverkotlin.R
import com.example.vlsilverkotlin.databinding.GuesstheworldFragmentGameBinding
import timber.log.Timber

class GuessthewordFragmentGame : Fragment() {
    lateinit var binding: GuesstheworldFragmentGameBinding
    private lateinit var viewModel: ViewModelGuessthewordFragmentGame
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.guesstheworld_fragment_game,
            container,
            false
        )
        Timber.i("Fragment Called")
        Timber.i("ViewModelProvider Called")
        viewModel = ViewModelProvider(this).get(ViewModelGuessthewordFragmentGame::class.java)
        binding.gameViewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
//        viewModel.score.observe(viewLifecycleOwner, Observer { newScore ->
//            binding.scoreText.text = newScore.toString()
//        })
//        viewModel.word.observe(viewLifecycleOwner, Observer { newWord ->
//            binding.wordText.text = newWord
//        })
        viewModel.eventGameFinish.observe(viewLifecycleOwner, Observer { newEventGameFinish ->
            if (newEventGameFinish == true){
                gameEndgame()
            }
        })
//        binding.wordText.text = viewModel.word.value
//        binding.scoreText.text = viewModel.score.value.toString()
//        binding.correctButton.setOnClickListener {
//            viewModel.clickGotButton()
////            binding.wordText.text = viewModel.word.value
////            binding.scoreText.text = viewModel.score.value.toString()
//        }
//        binding.skipButton.setOnClickListener {
//            viewModel.clickSkipButton()
//            binding.wordText.text = viewModel.word.value
//            binding.scoreText.text = viewModel.score.value.toString()
//        }
//        binding.endGameButton.setOnClickListener {
//            gameEndgame()
//            it.findNavController()
//                .navigate(
//                    GuessthewordFragmentGameDirections.actionGuessthewordFragmentGameToGuessthewordFragmentScore(
//                        viewModel.score
//                    )
//                )
//        }
        return binding.root
    }

    private fun gameEndgame() {
        Toast.makeText(context, "Game have just finished", Toast.LENGTH_SHORT).show()
        val action =
            GuessthewordFragmentGameDirections.actionGuessthewordFragmentGameToGuessthewordFragmentScore(
                viewModel.score.value?:0
            )
        NavHostFragment.findNavController(this).navigate(action)
        viewModel.finishComplete()
    }

}