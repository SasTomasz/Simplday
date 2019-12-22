package com.example.android.simplday.fragment


import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.EditText
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.android.simplday.MainActivity

import com.example.android.simplday.R
import com.example.android.simplday.TaskViewModel
import com.example.android.simplday.databinding.FragmentMainBinding
import com.example.android.simplday.databinding.FragmentTaskBinding

/**
 * A simple [Fragment] subclass.
 */
class TaskFragment : Fragment() {
    private val EDIT_MODE: Int = 1
    private val VIEW_MODE: Int = 0
    private var mode: Int = VIEW_MODE
    private lateinit var viewModel: TaskViewModel
    private lateinit var binding: FragmentTaskBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_task, container, false
        )


        // Inflate the layout for this fragment
        viewModel = ViewModelProviders.of(this).get(TaskViewModel::class.java)
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_task, menu)
    }



    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.menu_save -> {
                Toast.makeText(context, "save clicked", Toast.LENGTH_SHORT).show()
                navigateToMainFragment()
                true
            }
            else -> super.onOptionsItemSelected(item)

        }
    }

    private fun navigateToMainFragment(){
        val taskDescription = binding.etTaskName.text.toString()
        val priority = binding.etPriority.text.toString()
        val action = TaskFragmentDirections.
            actionTaskFragmentToMainFragment(taskDescription, priority)
        findNavController().navigate(action)


    }
}
