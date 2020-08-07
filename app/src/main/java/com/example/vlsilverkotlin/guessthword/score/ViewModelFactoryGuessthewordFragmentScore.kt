package com.example.vlsilverkotlin.guessthword.score

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import timber.log.Timber

class FactoryViewModelGuessthewordFragmentScore(private val finalScore:Int) :ViewModelProvider.Factory {
    init {
        Timber.i("FactoryViewModelGuessthewordFragmentScore Called")
    }

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ViewModelGuessthewordFragmentScore::class.java)){
            return ViewModelGuessthewordFragmentScore(finalScore) as T
        }
        throw IllegalAccessException("Unknown ViewModel class")
    }
}