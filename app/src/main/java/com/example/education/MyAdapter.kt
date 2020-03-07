package com.example.education

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import java.util.zip.Inflater


/**
 * how to use DiffUtils?
 * 1 - inherit from DiffUtil.Callback and implement 4 method
 * 2-  get gitResult
 *  val diffCallback = MyDiffCallback (oldList, newList)
 *  var result = DiffUtil.calculateDiff(diffCallback)
 *  result.dispatchUpdatesTo(this)
 */


class MyAdapter constructor(private val context: Context) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    private var myList: List<MyData> = ArrayList()

    fun notifyAboutChanges(newList: List<MyData>) {
        val _oldList = myList
        myList = newList

        val diff = MyDiffUtilCallback(_oldList, myList)
        val result = DiffUtil.calculateDiff(diff)
        result.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v = LayoutInflater.from(context).inflate(R.layout.view_cell, parent, false)
        return MyViewHolder(v)
    }

    override fun getItemCount(): Int {
        return myList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(myList[position])
    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val id: TextView by lazy { view.findViewById<TextView>(R.id.id_text) }
        val name: TextView by lazy { view.findViewById<TextView>(R.id.name_text) }
        val age: TextView by lazy { view.findViewById<TextView>(R.id.age_text) }

        fun bind(data: MyData) {
            id.text = data.id.toString()
            name.text = data.name.toString()
            age.text = data.age.toString()
        }
    }

    class MyDiffUtilCallback constructor(
        private val oldList: List<MyData>,
        private val newList: List<MyData>
    ) : DiffUtil.Callback() {

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition].id == newList[newItemPosition].id
        }

        override fun getOldListSize(): Int {
            return oldList.size
        }

        override fun getNewListSize(): Int {
            return newList.size
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            val oldItem = oldList[oldItemPosition]
            val newItem = newList[newItemPosition]
            return oldItem == newItem
        }
    }
}