package com.example.f1driverapp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.f1driverapp.data.DriverEntity

import com.example.f1driverapp.databinding.FragmentMainBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class MainFragment  : Fragment(),
      DriversListAdapter.ListItemListener {


    private lateinit var viewModel: MainViewModel
    private lateinit var binding: FragmentMainBinding
    private lateinit var adapter: DriversListAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        (activity as AppCompatActivity)
            .supportActionBar?.setDisplayHomeAsUpEnabled(false)
        setHasOptionsMenu(true)

        binding = FragmentMainBinding.inflate(inflater, container, false)
        // remember viewModel contains the MutableLiveData which is the list of Drivers
        // we will use this later to populate the RecyclerView and observe it for changes
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        // with is used to access an object attributes, without have to refer to the object every time
        // with is actually a function, and the object in this case is the recyclerView
        with(binding.recyclerView) {
            setHasFixedSize(true)
            val divider = DividerItemDecoration(
                context, LinearLayoutManager(context).orientation
            )
            addItemDecoration(divider)
            // without using with you may have done this...
            // binding.recyclerView.addItemDecoration(divider)
        }

        viewModel.drivers.observe(viewLifecycleOwner, Observer {
            // for debugging - Log.i() to the Logcat during execution and view Info messages with the tag TAG (see constants for the literal string)
            Log.i(TAG, it.toString())

            adapter = DriversListAdapter(it, this@MainFragment)
            binding.recyclerView.adapter = adapter
            binding.recyclerView.layoutManager = LinearLayoutManager(activity)
        })

        return binding.root

    }

    override fun onItemClick(driver: DriverEntity) {

        // Log - print out to logcat to help with debugging if errors occur
        // TAG is a constant defined in Constants.kt - you can search yhe logcat using this TAG to help with debugging errors
        Log.i(TAG, "onItemClick : Received Driver name ${driver}")
        val action = MainFragmentDirections.actionMainFragmentToEditorFragment(driver)
        findNavController().navigate(action)
    }



}


