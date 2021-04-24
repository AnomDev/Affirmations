package com.serbladev.affirmations.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.serbladev.affirmations.R
import com.serbladev.affirmations.model.Affirmation


/**
 * Adapter for the [RecyclerView] in [MainActivity]. Displays [Affirmation] data object.
 */

class ItemAdapter (private val context: Context, private val dataset: List<Affirmation>) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    // RecyclerView doesn't interact directly with item views, but deals with ViewHolders instead. A ViewHolder represents a single list item view in RecyclerView, and can be reused when possible
    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder.
    // Each data item is just an Affirmation object.
    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.item_title)
        val imageView: ImageView = view.findViewById(R.id.item_image)
    }


    /**
     * Create new views (invoked by the layout manager)
     */
    // The onCreateViewHolder()method is called by the layout manager to create new view holders for the RecyclerView (when there are no existing view holders that can be reused).
    // Remember that a view holder represents a single list item view.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        //Here we obtain an instance of LayoutInflater from the provided context (context of the parent). The layout inflater knows how to inflate an XML layout into a hierarchy of view objects.
        val adapterLayout = LayoutInflater.from(parent.context)
            //With this other method call, we inflate the actual list item view.
            .inflate(R.layout.list_item, parent, false)

        return ItemViewHolder(adapterLayout)
    }


    /**
     * Replace the contents of a view (invoked by the layout manager)
     */
    //This method is called by the layout manager in order to replace the contents of a list item view.
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]

        //This line of code updates the view holder to show the affirmation string.
        holder.textView.text = context.resources.getString(item.stringResourceId)
        holder.imageView.setImageResource(item.imageResourceId)
    }


    /**
     * Return the size of your dataset (invoked by the layout manager)
     */
    //The getItemCount() method needs to return the size of your dataset. Your app's data is in the dataset property that you are passing into the ItemAdapter constructor, and you can get its size with size.
    override fun getItemCount() : Int {
        return dataset.size    }

}