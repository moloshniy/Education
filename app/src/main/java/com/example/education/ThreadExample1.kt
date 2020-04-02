package com.example.education

import android.util.Log

class ThreadExample1 {

    @Volatile
    var x = 0

    fun start(){
    Thread{
        while (true) {
            x++
        }
    }.start()

    Thread{
        while (true) {
            if (x%2 == 0)
                Log.e("qqq","$x + x")
        }
    }.start()
    }

}