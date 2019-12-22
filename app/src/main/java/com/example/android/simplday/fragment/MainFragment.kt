package com.example.android.simplday.fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs

import com.example.android.simplday.R
import com.example.android.simplday.databinding.FragmentMainBinding
import kotlinx.android.synthetic.main.fragment_main.*

/**
 * A simple [Fragment] subclass.
 */
class MainFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = DataBindingUtil.inflate<FragmentMainBinding>(
            inflater,
            R.layout.fragment_main, container, false
        )
        val priority= MainFragmentArgs.fromBundle(arguments!!).priority
        val taskDescription = MainFragmentArgs.fromBundle((arguments!!)).taskDescription

        binding.fab.setOnClickListener { view ->
            view.findNavController().navigate(R.id.action_mainFragment_to_taskFragment)
        }

        binding.tvTaskDescription.text = taskDescription
        binding.tvPriority.text = priority

        return binding.root



        /**
         * todo 01 create view model for MainFragment
         * todo 02 check if Main fragment is navigate from TaskFragment
         * todo 03 create mode in Task fragment for show only and editing (maybe double click)
         *
         *
         * todo 04 when you finish start next codelab Android Kotlin Fundamentals 05.2:
         * todo 04 LiveData and LiveData observers
         */


    }


}
