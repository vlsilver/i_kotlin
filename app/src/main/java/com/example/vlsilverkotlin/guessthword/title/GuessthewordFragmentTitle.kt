package com.example.vlsilverkotlin.guessthword.title

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.vlsilverkotlin.R
import com.example.vlsilverkotlin.databinding.GuessthewordFragmentTitleBinding
import com.example.vlsilverkotlin.guessthword.game.GuessthewordFragmentGameDirections
import com.example.vlsilverkotlin.guessthword.score.GuessthewordFragmentScoreDirections
import kotlinx.android.synthetic.main.activity_main.*

class GuessthewordFragmentTitle : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<GuessthewordFragmentTitleBinding>(
            inflater, R.layout.guesstheword_fragment_title, container,
            false
        )
        binding.playGameButton.setOnClickListener {
            it.findNavController()
                .navigate(GuessthewordFragmentTitleDirections.actionGuessthewordFragmentTitleToGuessthewordFragmentGame())
        }
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.opitions_menu, menu)
    }

//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        when (item.itemId) {
//            R.id.menu_aboutApp -> {
//                this.findNavController()
//                    .navigate(GuessthewordFragmentScoreDirections.actionGuessthewordFragmentScoreToGuessthewordFragmentTitle())
//            }
//            R.id.menu_ruleApp -> {
//                this.findNavController()
//                    .navigate(GuessthewordFragmentScoreDirections.actionGuessthewordFragmentScoreToGuessthewordFragmentTitle())
//            }
//
//        }
//        return onOptionsItemSelected(item)
//    }

}
