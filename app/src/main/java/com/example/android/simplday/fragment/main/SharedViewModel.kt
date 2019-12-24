package com.example.android.simplday.fragment.main

import android.util.Log
import androidx.lifecycle.ViewModel

/**
 * This is class for sharing data in Main Activity
 */
class SharedViewModel: ViewModel() {
    var taskDescription = "There is no task"
    var priority = "C"

    init {
        Log.i("SharedViewModel", "View model created")
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("SharedViewModel", "ViewModel destroyed")
    }
}