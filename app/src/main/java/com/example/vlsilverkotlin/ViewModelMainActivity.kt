package com.example.vlsilverkotlin

import android.provider.Settings.Global.getString
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ViewModelMainActivity : ViewModel(){
    private val _aboutFragmentApp = MutableLiveData<String>()
    val aboutFragmentApp : LiveData<String>
        get() = _aboutFragmentApp

    fun setaboutFragment(text: String){
        if(text.isNotEmpty()){
        _aboutFragmentApp.value = text}
        else{
            _aboutFragmentApp.value = "NGUYEN VANG LINH"
        }
    }
}