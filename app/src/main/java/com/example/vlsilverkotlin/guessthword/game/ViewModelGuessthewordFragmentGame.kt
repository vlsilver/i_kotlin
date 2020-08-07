package com.example.vlsilverkotlin.guessthword.game

import android.os.CountDownTimer
import android.text.format.DateUtils
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import timber.log.Timber

class ViewModelGuessthewordFragmentGame : ViewModel() {
    companion object {
        private const val DONE = 0L
        private const val ONE_SECOND = 1000L
        private const val COUNTDOWN_TIME = 10000L
    }

    private val timer: CountDownTimer
    private val _currentTime = MutableLiveData<Long>()
    private var wordListStart: MutableList<String> = wordList.shuffled().toMutableList()
    private var wordListSkip: MutableList<String> = mutableListOf()
    private val _word = MutableLiveData<String>()
    private val _score = MutableLiveData<Int>()
    private val _eventGameFinish = MutableLiveData<Boolean>()
    private val currentTime: LiveData<Long>
        get() = _currentTime
    val score: LiveData<Int>
        get() = _score
    val word: LiveData<String>
        get() = _word
    val eventGameFinish: LiveData<Boolean>
        get() = _eventGameFinish

    init {
        timer = object : CountDownTimer(COUNTDOWN_TIME, ONE_SECOND) {
            override fun onTick(millisUntilFinished: Long) {
                _currentTime.value = millisUntilFinished / ONE_SECOND
            }

            override fun onFinish() {
                _currentTime.value = DONE
                clickSkipButton()
            }
        }
        timer.start()
        _word.value = wordListStart[0]
        _score.value = 0
        Timber.i("ViewModelGuessthewordFragmentGame is CREATE")
    }

    val currentTimeString = Transformations.map(currentTime) { time ->
        DateUtils.formatElapsedTime(time)
    }
    val randomWord = Transformations.map(word) { newWord ->
        val positionWord = newWord.indices.random()
        "Current word has "+ newWord.length+" letters" +
        "\nThe letter at position " +(positionWord.plus(1))+" is: "+ newWord[positionWord].toUpperCase()
    }

    fun clickGotButton() {
        _score.value = (score.value)?.plus(1)
        if (wordListStart.isNotEmpty()) {
            wordListStart.removeAt(0)
            if (wordListStart.isNotEmpty()) {
                _word.value = wordListStart[0]
            } else {
                wordListStart = wordListSkip
                wordListSkip = mutableListOf()
                if (wordListStart.isEmpty()) {
                    clickEndButton()
                } else {
                    _word.value = wordListStart[0]
                }
            }

        } else {
            wordListStart = wordListSkip
            if (wordListStart.isNotEmpty()) {
                _word.value = wordListStart[0]
            } else {
                clickEndButton()
                _score.value = (_score.value)?.minus(1)
            }
        }
        timer.start()
    }

    fun clickSkipButton() {
        if (wordListStart.isNotEmpty()) {
            wordListSkip.add(wordListStart[0])
            wordListStart.removeAt(0)
            if (wordListStart.isNotEmpty()) {
                _word.value = wordListStart[0]
            } else {
                wordListStart = wordListSkip
                wordListSkip = mutableListOf()
                _word.value = wordListStart[0]
            }
        } else {
            wordListStart = wordListSkip
            wordListSkip = mutableListOf()
            if (wordListStart.isNotEmpty()) {
                _word.value = wordListStart.removeAt(0)
            } else {
                clickEndButton()
            }
        }
        timer.start()
    }

    fun clickEndButton() {
        _eventGameFinish.value = true
    }

    fun finishComplete() {
        _eventGameFinish.value = false
    }

    override fun onCleared() {
        super.onCleared()
        timer.cancel()
        Timber.i("ViewModelGuessthewordFragmentGame Destroyed")
    }
}