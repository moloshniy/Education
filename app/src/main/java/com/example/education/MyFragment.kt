package com.example.education


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.education.*
import org.w3c.dom.Text

/**
 * A simple [Fragment] subclass.
 */
class MyFragment : Fragment() {
    private val textView: TextView by provideLazyLoad( {
            view!!.findViewById<TextView>(R.id.textview)
       }, {viewLifecycleOwner})

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.e("qqq", "${textView.hashCode()}")
    }


}
