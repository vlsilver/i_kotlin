package com.example.vlsilverkotlin.dessertclick

import androidx.lifecycle.*
import timber.log.Timber

class ViewModelDessertClickFragment : ViewModel() {
    private var _dessertSold = MutableLiveData<Int>()
    private var _revenue = MutableLiveData<Int>()
    private var _currentDessertClick =
        MutableLiveData<DessertClick>()
    val dessertSold: LiveData<Int>
        get() = _dessertSold
    val revenue: LiveData<Int>
        get() = _revenue
    val currentDessertClick: LiveData<DessertClick>
        get() = _currentDessertClick

//    var secondsCount = 0
//    var handler = Handler()
//    lateinit var runnable: Runnable

    init {
        _dessertSold.value = 0
        _revenue.value = 0
        _currentDessertClick.value = allDessertClick.shuffled()[0]
        Timber.i("ViewModelDessertClickFragment Called")
    }

    fun onClickDessert() {
        _revenue.value = _currentDessertClick.value?.price?.let { _revenue.value?.plus(it) }
        _dessertSold.value = _dessertSold.value?.plus(1)
        for (item in allDessertClick) {
            if (_dessertSold.value!! >= item.startProductionAmount) {
                _currentDessertClick.value = item
            }
        }
    }
}

