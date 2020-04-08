package com.example.education.Chain

import android.util.Log

class LengthFilter : Filter() {

    override fun filter(q:Int) {
        this.q = q
        Log.e("qqq", "str lenght = ${q}")
        filter?.filter(q)
    }
}