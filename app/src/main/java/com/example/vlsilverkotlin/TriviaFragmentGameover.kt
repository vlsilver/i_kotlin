package com.example.vlsilverkotlin

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.*
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.vlsilverkotlin.databinding.TriviaFragmentGameoverBinding

class TriviaFragmentGameover : Fragment() {
    private var numQuestion = 5
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<TriviaFragmentGameoverBinding>(
            inflater, R.layout.trivia_fragment_gameover, container, false
        )
            val args = TriviaFragmentGameoverArgs.fromBundle(arguments!!)
            binding.tryAgainButton.setOnClickListener {
                hideKeyboard()
                if (binding.editTextNumQuestions.text.isNotEmpty()) {
                    numQuestion = binding.editTextNumQuestions.text.toString().toInt()
                }
                it.findNavController()
                    .navigate(
                        TriviaFragmentGameoverDirections.actionTriviaFragmentGameoverToTriviaFragmentGame(
                            args.numQuestions,
                            args.numCorrect,
                            numQuestion
                        )
                    )
            }
            Toast.makeText(
                context,
                "NumCorrect: ${args.numCorrect}, NumQuestion: ${args.numQuestions}",
                Toast.LENGTH_SHORT
            ).show()
            setHasOptionsMenu(true)
            (activity as AppCompatActivity).supportActionBar?.title = "Trivia"
            binding.editTextNumQuestions.requestFocus()
            return binding.root
        }

        private fun shareAction(): Intent {
            val dataShare = TriviaFragmentGamewonArgs.fromBundle(arguments!!)
            val shareIntent = Intent(Intent.ACTION_SEND)
            shareIntent.setType("text/plain").putExtra(
                Intent.EXTRA_TEXT,
                getString(R.string.share_success_text, dataShare.numCorrect, dataShare.numQuestions)
            )
            return shareIntent
        }

        private fun setTilteActionbar() {
        }

        override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
            super.onCreateOptionsMenu(menu, inflater)
            inflater.inflate(R.menu.share_menu, menu)
            if (null == shareAction().resolveActivity(activity!!.packageManager)) {
                menu.findItem(R.id.share).isVisible = false
            }
        }

        override fun onOptionsItemSelected(item: MenuItem): Boolean {
            when (item.itemId) {
                R.id.share -> startActivity(shareAction())
            }
            return super.onOptionsItemSelected(item)
        }
    private fun hideKeyboard(){
        val inputMethodManager = activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view?.windowToken, 0)
    }
}


