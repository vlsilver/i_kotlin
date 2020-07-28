package com.example.vlsilverkotlin

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.vlsilverkotlin.databinding.TriviaFragmentTitleBinding


class TriviaFragmentTitle : Fragment() {
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
        setTilteActionbar()
        binding.playButton.setOnClickListener {
            it.findNavController().navigate(R.id.action_triviaFragmentTitle_to_triviaFragmentGame)
        }
        return binding.root
    }

    private fun setTilteActionbar() {
        (activity as AppCompatActivity).supportActionBar?.title = "Trivia"
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.opitions_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(
            item,
            view!!.findNavController()
        ) or super.onOptionsItemSelected(item)
    }


}