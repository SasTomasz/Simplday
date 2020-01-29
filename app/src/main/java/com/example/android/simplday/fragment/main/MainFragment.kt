package com.example.android.simplday.fragment.main


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.android.simplday.R
import com.example.android.simplday.database.TaskDao
import com.example.android.simplday.database.TaskDatabase
import com.example.android.simplday.databinding.FragmentMainBinding

/**
 * A simple [Fragment] subclass.
 */
class MainFragment : Fragment() {
    // ViewModel for sharing data in MainActivity
    lateinit var viewModel: MainViewModel
    lateinit var viewModelFactory: MainViewModelFactory
    lateinit var database: TaskDao


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = DataBindingUtil.inflate<FragmentMainBinding>(
            inflater,
            R.layout.fragment_main, container, false
        )

        val application = requireNotNull(this.activity).application
        database = TaskDatabase.getInstance(application).taskDatabaseDao

        Log.i("MainFragment", "ViewModelProviders.of")
        viewModelFactory = MainViewModelFactory(database)
        viewModel = ViewModelProviders.of(this, viewModelFactory)
            .get(MainViewModel::class.java)

        binding.lifecycleOwner = this
        binding.mainViewModel = viewModel

        return binding.root


        /**
         * todo 4-1 use coroutines with database
         *
         * todo 0-1 create mode in Task fragment for show only and editing (maybe double click)
         * todo 0-2 check if Main fragment is navigate from TaskFragment
         *
         * TODO at one time try to create class or classes for click handlers from fragments or
         * TODO activities or even menus(if it's a good practice -> I don't know yet)
         */


    }


}
