package com.example.android.simplday.fragment.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.android.simplday.database.TaskDao

class MainViewModelFactory(private val dataSource: TaskDao) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom((MainViewModel::class.java))) {
            return MainViewModel(dataSource) as T
        }
        throw java.lang.IllegalArgumentException("Unknown ViewModel class")
    }
}