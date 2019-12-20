package com.example.android.simplday.fragment


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.android.simplday.MainActivity

import com.example.android.simplday.R
import com.example.android.simplday.TaskViewModel

/**
 * A simple [Fragment] subclass.
 */
class TaskFragment : Fragment() {
    private val EDIT_MODE: Int = 1
    private val VIEW_MODE: Int = 0
    private var mode: Int = VIEW_MODE
    private lateinit var viewModel: TaskViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        viewModel = ViewModelProviders.of(this).get(TaskViewModel::class.java)
        return inflater.inflate(R.layout.fragment_task, container, false)
    }


}
