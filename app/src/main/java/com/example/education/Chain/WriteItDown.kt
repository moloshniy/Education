package com.example.education.Chain

import android.util.Log
import java.io.FilterWriter

class WriteItDown
{
//    fun write(filter: Filter, int:Int){
//       var q = int
//        filter.filter(q)
//        Log.e("qqq", q.toString())
//    }

    fun write(int:Int, func:()->Array<Filter>){

        var q = int
        val arr = func()

      for ( i in arr.indices-1) {
          arr[i].setNext(arr[i+1])
      }
        arr[0].filter(q)
        Log.e("qqq", q.toString())
    }



}