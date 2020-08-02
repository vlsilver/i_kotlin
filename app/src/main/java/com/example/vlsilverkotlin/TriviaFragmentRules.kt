package com.example.vlsilverkotlin

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.vlsilverkotlin.databinding.TriviaFragmentRulesBinding

class TriviaFragmentRules : Fragment() {
    private var numQuestion = 5
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

        (activity as AppCompatActivity).supportActionBar?.title = "Trivia"
        binding.playButton.setOnClickListener {
            hideKeyboard()
            if (binding.editTextNumQuestions.text.isNotEmpty()) {
                numQuestion = binding.editTextNumQuestions.text.toString().toInt()
            }
            it.findNavController()
                .navigate(
                    TriviaFragmentRulesDirections.actionTriviaFragmentRulesToTriviaFragmentGame(
                        0,
                        0,
                        numQuestion
                    )
                )
        }
        binding.editTextNumQuestions.requestFocus()
        return binding.root
    }

    private fun hideKeyboard(){
        val inputMethodManager = activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view?.windowToken, 0)
    }
}
