package com.example.android.simplday.fragment.main

import android.util.Log
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import com.example.android.simplday.R
import com.example.android.simplday.model.Task

/**
 * This is class for sharing data in Main Activity
 */
class SharedViewModel: ViewModel() {
    // description of task
    private val _task = MutableLiveData<Task>(Task())
    val task: LiveData<Task>
        get() = _task

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
        _task.value?.taskName = taskDescription
        _task.value?.priority = priority
    }

    fun onNavigate(view: View) {
        view.findNavController().navigate(R.id.action_mainFragment_to_taskFragment)

    }
}