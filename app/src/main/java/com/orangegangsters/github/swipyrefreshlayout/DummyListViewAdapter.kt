package com.orangegangsters.github.swipyrefreshlayout

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.orangegangsters.github.swiperefreshlayout.databinding.ListviewCellBinding
import java.util.*

/**
 * Created by oliviergoutay on 1/23/15.
 */
class DummyListViewAdapter() :
    RecyclerView.Adapter<DummyListViewAdapter.VH>() {
    private val mDummyStrings: List<String>
    val dummyStrings: List<String>
        get() {
            val dummyStrings: MutableList<String> = ArrayList()
            dummyStrings.add("You want")
            dummyStrings.add("to test")
            dummyStrings.add("this library")
            dummyStrings.add("from both")
            dummyStrings.add("direction.")
            dummyStrings.add("You may")
            dummyStrings.add("be amazed")
            dummyStrings.add("when done")
            dummyStrings.add("so!")
            dummyStrings.add("I am")
            dummyStrings.add("going to")
            dummyStrings.add("add a little")
            dummyStrings.add("more lines")
            dummyStrings.add("for big")
            dummyStrings.add("smartphones.")
            return dummyStrings
        }

    init {
        mDummyStrings = dummyStrings
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListviewCellBinding.inflate(inflater, parent, false)
        return VH(binding)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.mCellNumber.text = "" + position
        holder.mCellText.text = mDummyStrings[position]
    }

    override fun getItemCount(): Int = mDummyStrings.size

    class VH(val binding: ListviewCellBinding) : RecyclerView.ViewHolder(binding.root) {
        var mCellNumber: TextView = binding.cellNumber
        var mCellText: TextView = binding.cellText
    }
}