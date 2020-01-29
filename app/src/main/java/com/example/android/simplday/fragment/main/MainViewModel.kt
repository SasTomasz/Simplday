package com.example.android.simplday.fragment.main

import android.util.Log
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import com.example.android.simplday.R
import com.example.android.simplday.database.TaskDao
import com.example.android.simplday.model.Task
import com.example.android.simplday.stringListOfTasks

/**
 * This is class for sharing data in Main Activity
 */
class MainViewModel(
    val database: TaskDao
) : ViewModel() {
    private val listOfAllTasks = database.getAllTasks()
    val formatListsOfAllTasks = Transformations.map(listOfAllTasks) { tasks ->
        stringListOfTasks(tasks)
    }
    // description of task
    private val _task = MutableLiveData<Task>(Task())
    val task: LiveData<Task>
        get() = _task

    init {
        Log.i("MainViewModel", "View model created")
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("MainViewModel", "ViewModel destroyed")
    }

    fun onNavigate(view: View) {
        view.findNavController().navigate(R.id.action_mainFragment_to_taskFragment)

    }
}

// todo refactor this view model to use it only with MainFragment, create viewmodel factory,
//  check all usages in
//  MainFragment,
//  TaskFragment,
//  fragment_main.xml

// todo for tests create safeargs and test if it pass data between Main and Task Fragments