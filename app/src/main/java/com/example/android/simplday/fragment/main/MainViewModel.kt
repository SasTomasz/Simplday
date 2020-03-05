package com.example.android.simplday.fragment.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android.simplday.database.TaskDao

/**
 * This is ViewModel class for MainFragment
 */
class MainViewModel(
    val database: TaskDao
) : ViewModel() {
    val listOfAllTasks = database.getAllTasks()

    private val _navigateToTask = MutableLiveData<Boolean>()
    val navigateToTask: LiveData<Boolean>
        get() = _navigateToTask

    private val _navigateToDetail = MutableLiveData<Long?>()
    val navigateToDetail: LiveData<Long?>
        get() = _navigateToDetail

    override fun onCleared() {
        super.onCleared()
        Log.i("MainViewModel", "ViewModel destroyed")
    }

    fun doneNavigating() {
        _navigateToTask.value = false
    }

    fun startNavigating() {
        _navigateToTask.value = true
    }

    fun onClickTaskItem(taskId: Long?){
        _navigateToDetail.value = taskId
    }

    fun onDetailNavigated(){
        _navigateToDetail.value = null
    }


}
