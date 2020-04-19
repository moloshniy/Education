package com.example.education


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import kotlinx.android.synthetic.*

/**
 * A simple [Fragment] subclass.
 */

class Fragment0 : Fragment() {

    interface Fr0Finish {
    fun finish0()
}

var listener:Fr0Finish? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is Fr0Finish)
        listener = context
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment0, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.button).setOnClickListener {
            listener!!.finish0()
        }
    }

}
