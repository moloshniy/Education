package com.example.education.coldobservables

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import io.reactivex.rxjava3.core.Observable
import tag
import java.time.LocalTime

class CallableExample {
    @RequiresApi(Build.VERSION_CODES.O)
    fun start(){
        fun1()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun fun1(){
        Log.e(tag(),LocalTime.now().toString())
        val myObservable: Observable<LocalTime> = Observable.fromCallable(LocalTime::now)
        Thread.sleep(5000)
        myObservable.subscribe{
            Log.e(tag(),LocalTime.now().toString())
        }
    }
}