package com.example.vlsilverkotlin.guessthword.score

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.NavHostFragment
import timber.log.Timber

class ViewModelGuessthewordFragmentScore(finalScore: Int): ViewModel() {
    private val _score = MutableLiveData<Int>()
    private val _eventPlayAgain = MutableLiveData<Boolean>()
    val score:LiveData<Int>
        get() = _score
    val eventPlayAgain:LiveData<Boolean>
        get() = _eventPlayAgain
    init {
        _score.value = finalScore
        Timber.i("ViewModelGuessthewordFragmentScore Called")
    }
    fun playAgaint(){
        _eventPlayAgain.value = true
    }
//    fun playAgaintComplete(){
//        _eventPlayAgain.value = false
//    }
}