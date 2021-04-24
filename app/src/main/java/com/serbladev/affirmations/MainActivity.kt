package com.serbladev.affirmations

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.serbladev.affirmations.adapter.ItemAdapter
import com.serbladev.affirmations.data.Datasource

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Create an instance of Datasource, and call the loadAffirmations() method on it. Store the returned list of affirmations in a val named myDataset.
        val myDataset = Datasource().loadAffirmations()

        // Create a variable called recyclerView and use findViewById()to find a reference to the RecyclerView within the layout.
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)

        // To tell the recyclerView to use the ItemAdapter class you created, create a new ItemAdapter instance. That instance expects two parameters: context of the activity & the affirmations of myDataset
        // Assign the ItemAdapter object to the adapter property of the recyclerView.
        recyclerView.adapter = ItemAdapter(this, myDataset)

        //Since the layout size of your RecyclerView is fixed in the activity layout, you can set the setHasFixedSize parameter of the RecyclerView to true.
        // This setting is only needed to improve performance. Use this setting if you know that changes in content do not change the layout size of the RecyclerView.
        recyclerView.setHasFixedSize(true)

    }
}