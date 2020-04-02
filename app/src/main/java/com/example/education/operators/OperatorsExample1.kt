package com.example.education.operators

import android.util.Log
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.functions.Action
import tag
import java.util.concurrent.TimeUnit


/**Observable.timer
This operator let’s you specify a time delay before emitting an event.
This emits a single Long with a value 0L before terminating.
*/
class OperatorsExample1 {
    fun start(){
        fun2()
    }

    fun fun1(){
        Observable.timer(1, TimeUnit.SECONDS)
            .subscribe{
                Log.e(tag(),it.toString())
            }
    }

    /**retryWhen will only react when onComplete of the input is triggered. **/

    fun fun2(){
        val observer = object : Observer<String>{
            override fun onComplete() {

            }

            override fun onSubscribe(d: Disposable?) {
                Log.e(tag(),"onSubscribe")
            }

            override fun onNext(t: String?) {
                Log.e(tag(),t.toString())
            }

            override fun onError(e: Throwable?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

        }
        /**
         * WHILE OBSERVER INSIDE OF REPEAT WHEN DOESNT RETURN ONCOMPLITE OR ONERROR  IT WILL REPEAT EMIT ITEMS
         */
        Observable.just("hello", "hi")
            .repeatWhen {
                Observable.range(1,3)
            }.subscribe(observer)

    }
}