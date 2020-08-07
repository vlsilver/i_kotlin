package com.example.vlsilverkotlin.trivia

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.vlsilverkotlin.*
import com.example.vlsilverkotlin.databinding.TriviaFragmentGameBinding

class TriviaFragmentGame : Fragment() {
    lateinit var currentQuestion: Question
    lateinit var answers: MutableList<String>
    private var questionIndex = 0
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
        val args = TriviaFragmentGameArgs.fromBundle(
            requireArguments()
        )
        randomQuestion()
        setQuestion()
        binding.game = this
        binding.submitButton.setOnClickListener { view: View ->
            var answerIndexUser = 0
            when (binding.questionRadioGroup.checkedRadioButtonId) {
                R.id.secondAnswerRadioButton -> answerIndexUser = 1
                R.id.thirdAnswerRadioButton -> answerIndexUser = 2
                R.id.fourthAnswerRadioButton -> answerIndexUser = 3
            }
            if (answers[answerIndexUser] == currentQuestion.answers[0]) {
                questionIndex += 1
                if (questionIndex < args.numQuestion) {
                    currentQuestion = question[questionIndex]
                    setQuestion()
                    binding.invalidateAll()
                } else {
                    view.findNavController()
                        .navigate(
                            TriviaFragmentGameDirections.actionTriviaFragmentGameToTriviaFragmentGamewon(
                                args.numQuestion + args.totalQuestions,
                                questionIndex + args.totalCorrect
                            )
                        )
                }
            } else {
                view.findNavController()
                    .navigate(
                        TriviaFragmentGameDirections.actionTriviaFragmentGameToTriviaFragmentGameover(
                            args.numQuestion + args.totalQuestions,
                            questionIndex + args.totalCorrect
                        )
                    )
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
        val args = TriviaFragmentGameArgs.fromBundle(
            requireArguments()
        )
        (activity as AppCompatActivity).supportActionBar?.title =
            getString(R.string.title_android_trivia_question, questionIndex + 1, args.numQuestion)
    }
}
