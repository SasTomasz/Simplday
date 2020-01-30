package com.example.android.simplday.fragment.main

import android.util.Log
import android.view.View
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import com.example.android.simplday.R
import com.example.android.simplday.database.TaskDao
import com.example.android.simplday.stringListOfTasks

/**
 * This is ViewModel class for MainFragment
 */
class MainViewModel(
    val database: TaskDao
) : ViewModel() {
    private val listOfAllTasks = database.getAllTasks()
    val formatListsOfAllTasks = Transformations.map(listOfAllTasks) { tasks ->
        stringListOfTasks(tasks)
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("MainViewModel", "ViewModel destroyed")
    }

    fun onNavigate(view: View) {
        view.findNavController().navigate(R.id.action_mainFragment_to_taskFragment)

    }
}
