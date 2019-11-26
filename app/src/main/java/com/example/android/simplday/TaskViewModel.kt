package com.example.android.simplday

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android.simplday.model.Task

class TaskViewModel: ViewModel() {
    init {
        Log.i("TaskViewModel", "View Model created")
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("TaskViewModel", "View Model destroyed")
    }
}