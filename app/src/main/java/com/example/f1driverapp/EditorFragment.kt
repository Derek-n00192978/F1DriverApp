package com.example.f1driverapp

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.f1driverapp.data.FavouriteEntity
import com.example.f1driverapp.databinding.EditorFragmentBinding


class EditorFragment : Fragment() {
    private val args: EditorFragmentArgs by navArgs()



    private lateinit var binding: EditorFragmentBinding
    private lateinit var viewModel: EditorViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        (activity as AppCompatActivity).supportActionBar?.let {
            it.setHomeButtonEnabled(true)
            it.setDisplayShowHomeEnabled(true)
            it.setDisplayHomeAsUpEnabled(true)
            it.setHomeAsUpIndicator(R.drawable.ic_check)
        }
        setHasOptionsMenu(true)

        binding = EditorFragmentBinding.inflate(inflater, container, false)

        // Set the givenName and nationality from the Driver object passed in from the MainFragment
        binding.givenName.setText(args.drivers.name)
        binding.nat.setText(args.driver.nationality)

        // create the viewModel, observe the live data (Favourite object for the current Driver)
        // if the live data changes update the layout so it displays those comments.
        viewModel = ViewModelProvider(this).get(EditorViewModel::class.java)
        viewModel.currentFavourite.observe(viewLifecycleOwner, Observer {
            binding.myNotes.setText(it.myNotes)
        })

        // tell the viewModel to get access the local database to see if there are favourite comments for the current driver
        viewModel.getFavourite(args.drivers.id)


        requireActivity().onBackPressedDispatcher.addCallback(
            viewLifecycleOwner,
            object : OnBackPressedCallback(true){
                override fun handleOnBackPressed(){
                    // you write the code for saveAndReturn - later this will need to save to the Database
                    saveAndReturn()
                }
            }
        )
        return binding.root
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            // When the home button is clicked, save changes then return to the MainFragment, which is the List
            android.R.id.home -> saveAndReturn()
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun saveAndReturn() : Boolean{
        // at the moment we save to favourites, even if there are no comments
        // Try insert a save or cancel functionality so this does not happen.
        viewModel.saveFavourite(FavouriteEntity(args.drivers.id, binding.myNotes.text.toString()))

        findNavController().navigateUp()
        return true
    }
}