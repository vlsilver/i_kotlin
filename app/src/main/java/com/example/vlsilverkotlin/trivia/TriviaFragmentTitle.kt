package com.example.vlsilverkotlin.trivia

import android.content.Context
import android.os.Bundle
import android.view.*
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.vlsilverkotlin.R
import com.example.vlsilverkotlin.databinding.TriviaFragmentTitleBinding


class TriviaFragmentTitle : Fragment() {
    private var numQuestion = 5
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<TriviaFragmentTitleBinding>(
            inflater,
            R.layout.trivia_fragment_title,
            container,
            false
        )
        setHasOptionsMenu(true)
        (activity as AppCompatActivity).supportActionBar?.title = "Trivia"
        binding.playButton.setOnClickListener {
            hideKeyboard()
            if (binding.editTextNumQuestions.text.isNotEmpty()) {
                numQuestion = binding.editTextNumQuestions.text.toString().toInt()
            }
            it.findNavController().navigate(
                TriviaFragmentTitleDirections.actionTriviaFragmentTitleToTriviaFragmentGame(
                    0,
                    0,
                    numQuestion
                )
            )
        }
        binding.editTextNumQuestions.requestFocus()
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.opitions_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_aboutApp -> {
                requireView().findNavController()
                    .navigate(TriviaFragmentTitleDirections.actionTriviaFragmentTitleToTriviaFragmentAbout2())
            }
            R.id.menu_ruleApp -> {
                requireView().findNavController()
                    .navigate(TriviaFragmentTitleDirections.actionTriviaFragmentTitleToTriviaFragmentRules())
            }
        }
//        return NavigationUI.onNavDestinationSelected(
//            item,
//            view!!.findNavController()
//        ) or
        return super.onOptionsItemSelected(item)
    }
    private fun hideKeyboard(){
        val inputMethodManager = activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view?.windowToken, 0)
    }
}