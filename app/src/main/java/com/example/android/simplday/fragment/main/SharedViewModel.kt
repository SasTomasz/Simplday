package com.example.android.simplday.fragment.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * This is class for sharing data in Main Activity
 */
class SharedViewModel: ViewModel() {
    // description of task
    private val _taskDescription = MutableLiveData<String>("There is no task")
    val taskDescription: LiveData<String>
        get() = _taskDescription

    // priority od task
    private val _priority = MutableLiveData<String>("C")
    val priority: LiveData<String>
        get() = _priority

    init {
        Log.i("SharedViewModel", "View model created")
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("SharedViewModel", "ViewModel destroyed")
    }

    /**
     * Saving Task Value
     * @param taskDescription is description of current task
     * @param priority is priority of current task
     */
    fun onSaveNewTask(taskDescription: String, priority: String){
        _taskDescription.value = taskDescription
        _priority.value = priority
    }
}