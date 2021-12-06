package com.example.f1driverapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.f1driverapp.data.DriverEntity
import com.example.f1driverapp.databinding.ListItemBinding




// a reference to the Driver List data is passed in during intialisation

class DriversListAdapter(private val driversList: List<DriverEntity>,
    // now a listener for each list item is also passed in.
    private val listener: ListItemListener) :
// Inherits from RecyclerView.Adapter
// it also has an inner class ViewHolder
    RecyclerView.Adapter<DriversListAdapter.ViewHolder>() {

        val selectedDrivers = arrayListOf<DriverEntity>()

    // Inner class details with
    inner class ViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        // binding to list_item.xml
        val binding = ListItemBinding.bind(itemView)
}
    // These 3 functions must be overridden

    // This function is called each time a new list Item is generated
    // its job is to decide which xml layout is used for the list item.
    // it gets a reference to the view and return the ViewHolder object
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        // list_item is a layout file, ctrl/cmd click will bring you to this file
        // you must create list_item.xml and design it as you want for one list item
        val view = inflater.inflate(R.layout.list_item, parent, false)
        return ViewHolder(view)
    }


    override fun getItemCount() = driversList.size

    // each time data is passed to the RecyclerView's row
    // You need to bind the data to that ViewHolder
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // get the plant you want to display from the plantsList
        val driver = driversList[position]
        // remember use with so you can refer to an objects attributes without contstantly mentioning the object
        with(holder.binding) {

            // same as holder.binding.plantName.text
            driverName.text = driver.givenName
            root.setOnClickListener{
                listener.onItemClick(driver)
            }


        }


    }
    interface ListItemListener {
        fun onItemClick(driver: DriverEntity)
    }
}