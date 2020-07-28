package com.example.vlsilverkotlin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.vlsilverkotlin.databinding.TriviaFragmentGameBinding
import kotlin.time.seconds

class TriviaFragmentGame : Fragment() {
    lateinit var currentQuestion: Question
    lateinit var answers: MutableList<String>
    private var questionIndex = 0
    private val numQuestion = Math.min((question.size + 1) / 2, 5)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<TriviaFragmentGameBinding>(
            inflater,
            R.layout.trivia_fragment_game,
            container,
            false
        )
        randomQuestion()
        setQuestion()
        binding.game = this
        binding.submitButton.setOnClickListener { view: View ->
            var answerIndexUser:Int = 0
            when (binding.questionRadioGroup.checkedRadioButtonId) {
                R.id.secondAnswerRadioButton -> answerIndexUser = 1
                R.id.thirdAnswerRadioButton -> answerIndexUser = 2
                R.id.fourthAnswerRadioButton -> answerIndexUser = 3
            }
            if (answers[answerIndexUser] == currentQuestion.answers[0]) {
                questionIndex += 1
                if (questionIndex < numQuestion) {
                    currentQuestion = question[questionIndex]
                    setQuestion()
                    binding.invalidateAll()
                } else {
                    view.findNavController()
                        .navigate(R.id.action_triviaFragmentGame_to_triviaFragmentGamewon)
                }
            } else {
                view.findNavController()
                    .navigate(R.id.action_triviaFragmentGame_to_triviaFragmentGameover)
            }
        }
        return binding.root
    }

    private fun randomQuestion() {
        question.shuffle()
    }

    private fun setQuestion() {
        currentQuestion = question[questionIndex]
        answers = currentQuestion.answers.toMutableList()
        answers.shuffle()

        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.title_android_trivia_question,questionIndex+1,numQuestion)
    }
}
