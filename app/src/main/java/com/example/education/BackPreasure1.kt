package com.example.education

import android.util.Log
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.ObservableOnSubscribe
import io.reactivex.rxjava3.schedulers.Schedulers
import tag

class BackPreasure1 {

    fun start() {

        Observable.create(ObservableOnSubscribe<Int> {
            repeat(10000) { i ->
                it.onNext(i)
            }
            Log.e(tag() + "obs", "obs-complite")
            it.onComplete()
        }).subscribeOn(Schedulers.computation())
            .observeOn(Schedulers.io())
            .subscribe(::onNext, ::onError, ::onComplite)
    }

    fun onNext(it:Int){
       // Thread.sleep(2000)
        System.out.println("next: " + it);
        Log.e(tag() + "subs", "subs onNext $it")
    }

    fun onComplite(){

        Log.e(tag() + "subs", "subs onComplite")
    }

    fun onError(t:Throwable){

        Log.e(tag() + "subs", "subs onError")
        throw Exception()
    }
}