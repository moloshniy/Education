package com.example.education

import android.app.Activity
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class Adapter : RecyclerView.Adapter<Adapter.BaseViewHolder>() {
    private val vhf = ViewHolderFactory()
    var list: List<MyData> = ArrayList()

    override fun getItemViewType(position: Int): Int {
        return list[position].getType()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter.BaseViewHolder {
        return vhf.getViewHolder(viewType, parent)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.bind(position)
    }

    abstract class BaseViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        abstract fun bind(position: Int)
    }


    class ViewHolderFactory() {

        fun getViewHolder(viewType: Int, parent: ViewGroup): BaseViewHolder {
            if (viewType == 0) {
                val v =
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.myviewholder, parent, false)
                return MyViewHolder(v)
            }
            throw Exception()
        }

        class MyViewHolder(view: View) : BaseViewHolder(view) {

            override fun bind(position: Int) {
                Log.e("qqq", "FRST VIEWHOLDER")
            }
        }

        class MyViewHolder2(view: View) : BaseViewHolder(view) {
            override fun bind(position: Int) {
                Log.e("qqq", "SECOND VIEWHOLDER")
            }
        }


    }
    fun Activity.asd(){

    }

}
