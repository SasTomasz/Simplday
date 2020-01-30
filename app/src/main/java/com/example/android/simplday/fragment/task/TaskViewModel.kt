package com.example.android.simplday.fragment.task

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android.simplday.database.TaskDao
import com.example.android.simplday.database.TaskForDatabase
import kotlinx.coroutines.*

class TaskViewModel(
    val database: TaskDao): ViewModel() {

    private var _task = MutableLiveData<TaskForDatabase>()
    val task: LiveData<TaskForDatabase>
        get() = _task

    private val viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    fun onSaveNewTask(name: String, priority: String) {
        uiScope.launch {
            val newTask = TaskForDatabase(taskName = name, taskPriority = priority)
            insert(newTask)
        }

    }

    private suspend fun insert(newTask: TaskForDatabase) {
        withContext(Dispatchers.IO) {
            database.insertTask(newTask)
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }


    // todo try to update data but after getting knowledge about recyclerView

}