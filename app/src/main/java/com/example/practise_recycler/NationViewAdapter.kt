package com.example.practise_recycler

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import coil.api.load
import coil.transform.CircleCropTransformation


import com.example.practise_recycler.NationFragment.OnListFragmentInteractionListener
import com.example.practise_recycler.models.Nation

/**
 * [RecyclerView.Adapter] that can display a [DummyItem] and makes a call to the
 * specified [OnListFragmentInteractionListener].
 * TODO: Replace the implementation with code for your data type.
 */
class NationViewAdapter (
    private val mValues: List<Nation>,
    private val mListener: OnListFragmentInteractionListener?
) : RecyclerView.Adapter<NationViewAdapter.ViewHolder>() {

    private val mOnClickListener: View.OnClickListener

    init {
        mOnClickListener = View.OnClickListener { v ->
            val item = v.tag as Nation
            // Notify the active callbacks interface (the activity, if the fragment is attached to
            // one) that an item has been selected.
            mListener?.onListFragmentInteraction(item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_nation_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mValues[position]
        with(holder.imageView) {
            this.load("https://img.geonames.org/flags/x/ae.gif"){
                placeholder(R.mipmap.ic_launcher_round)
            }
            tag = item
            setOnClickListener(mOnClickListener)
        }
    }

    override fun getItemCount(): Int = mValues.size

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        val imageView: ImageView
        init {
            imageView = mView.findViewById(R.id.imgNationFlag)
        }
    }
}
