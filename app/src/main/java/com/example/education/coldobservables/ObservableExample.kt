package com.example.education.coldobservables

import android.util.Log
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.ObservableOnSubscribe
import io.reactivex.rxjava3.schedulers.Schedulers
import tag

class ObservableExample {
    fun start(){
         fun1()
    }
    fun fun1(){
        val d= Observable.create<Int> {
            repeat(100){i->
                Thread.sleep(100)
                it.onNext(i)
            }
        }.subscribeOn(Schedulers.computation()).subscribe {
            Log.e(tag(),"$it")
        }
        Thread.sleep(2000)
        d.dispose()
    }
}