package com.example.android.simplday.fragment.main


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController

import com.example.android.simplday.R
import com.example.android.simplday.databinding.FragmentMainBinding

/**
 * A simple [Fragment] subclass.
 */
class MainFragment : Fragment() {
    // ViewModel for sharing data in MainActivity
    lateinit var viewModel: SharedViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = DataBindingUtil.inflate<FragmentMainBinding>(
            inflater,
            R.layout.fragment_main, container, false
        )
        Log.i("MainFragment", "ViewModelProviders.of")
        viewModel = activity?.run {
            ViewModelProviders.of(this)[SharedViewModel::class.java]
        } ?: throw Exception("Invalid Activity")

        binding.fab.setOnClickListener { view ->
            view.findNavController().navigate(R.id.action_mainFragment_to_taskFragment)
        }

        binding.tvTaskDescription.text = viewModel.taskDescription
        binding.tvPriority.text = viewModel.priority

        return binding.root


        /**
         * todo 0-1 create mode in Task fragment for show only and editing (maybe double click)
         * todo 0-2 check if Main fragment is navigate from TaskFragment
         */


    }


}
