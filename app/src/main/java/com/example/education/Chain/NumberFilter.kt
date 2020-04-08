package com.example.education.Chain

import android.util.Log

class NumberFilter:Filter() {

    override fun filter(q:Int) {
        this.q = q
        Log.e("qqq", " NUMBER FILTER str lenght = ${q}")
        filter?.filter(q)
    }

}