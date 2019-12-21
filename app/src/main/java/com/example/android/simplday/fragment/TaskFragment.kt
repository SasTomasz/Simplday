package com.example.android.simplday.fragment


import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
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
        setHasOptionsMenu(true)
        return inflater.inflate(R.layout.fragment_task, container, false)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_task, menu)
    }



    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.menu_save -> {
                Toast.makeText(context, "save clicked", Toast.LENGTH_SHORT).show()
            }

        }
        return super.onOptionsItemSelected(item)
    }
}
