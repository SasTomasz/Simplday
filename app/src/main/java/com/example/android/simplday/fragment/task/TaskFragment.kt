package com.example.android.simplday.fragment.task


import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.*
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.android.simplday.R
import com.example.android.simplday.database.TaskDao
import com.example.android.simplday.database.TaskDatabase
import com.example.android.simplday.databinding.FragmentTaskBinding

/**
 * A simple [Fragment] subclass.
 */
class TaskFragment : Fragment() {
    private lateinit var viewModel: TaskViewModel
    private lateinit var viewModelFactory: TaskViewModelFactory
    private lateinit var binding: FragmentTaskBinding
    private lateinit var dataSource: TaskDao

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_task, container, false
        )

        val application = requireNotNull(this.activity).application

        dataSource = TaskDatabase.getInstance(application).taskDatabaseDao

        viewModelFactory = TaskViewModelFactory(dataSource)


        Log.i("Task Fragment", "ViewModelProviders.of")
        viewModel = ViewModelProviders.of(this, viewModelFactory)
            .get(TaskViewModel::class.java)

        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_task, menu)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_save -> {
                Toast.makeText(context, "save clicked", Toast.LENGTH_SHORT).show()
                navigateToMainFragment()
                hideSoftKeyboard(view!!)
                true
            }
            else -> super.onOptionsItemSelected(item)

        }
    }

    /**
     * Saving all data and navigate to MainFragment
     */
    private fun navigateToMainFragment() {
//     todo   viewModel.onSaveNewTask(
//            binding.etTaskName.text.toString(),
//            binding.etPriority.text.toString()
//        ) save data in database
        val action =
            TaskFragmentDirections.actionTaskFragmentToMainFragment()
        findNavController().navigate(action)
    }

    /**
     * hide soft keyboard
     * @param view is active fragment view
     */
    private fun hideSoftKeyboard(view: View) {
        val imm = activity!!.getSystemService(Context.INPUT_METHOD_SERVICE)
                as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
