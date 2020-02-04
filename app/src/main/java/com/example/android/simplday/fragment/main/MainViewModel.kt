package com.example.android.simplday.fragment.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
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

    private val _navigateToTask = MutableLiveData<Boolean>()
    val navigateToTask: LiveData<Boolean>
        get() = _navigateToTask

    override fun onCleared() {
        super.onCleared()
        Log.i("MainViewModel", "ViewModel destroyed")
    }

//    fun onNavigate(view: View) {
//        view.findNavController().navigate(R.id.action_mainFragment_to_taskFragment)
//    }

    fun doneNavigating() {
        _navigateToTask.value = false
    }

    fun startNavigating() {
        _navigateToTask.value = true
    }


}
