package com.example.education.hotobservables

import android.util.Log
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.ObservableEmitter
import io.reactivex.rxjava3.core.ObservableOnSubscribe
import io.reactivex.rxjava3.functions.BiFunction
import io.reactivex.rxjava3.schedulers.Schedulers
import io.reactivex.rxjava3.subjects.AsyncSubject
import io.reactivex.rxjava3.subjects.PublishSubject
import tag
import java.util.concurrent.TimeUnit

class PublishSubjectExample {
    fun start() {
        fun3()
    }

    fun fun1() {
        val ps1 = PublishSubject.create<Int>()
        ps1.onNext(1)

        ps1.subscribe{
            Log.e(tag(), "1-  $it")
        }
        ps1.onNext(2)
        Thread.sleep(1000)

        ps1.subscribe{
            Log.e(tag(),"2-  $it")
        }
        Thread.sleep(3000)
        ps1.onNext(3)
        ps1.subscribe{
            Log.e(tag(),"3-  $it")
        }
    }

    fun fun2() {
        val ps1 = PublishSubject.create<Int>()
        ps1.onNext(1)

        ps1.subscribe{
            Log.e(tag(), "1-  $it")
        }
        ps1.onNext(2)
        Thread.sleep(1000)

        ps1.subscribe{
            Log.e(tag(),"2-  $it")
        }
        Thread.sleep(3000)
        ps1.onNext(3)
        ps1.subscribe{
            Log.e(tag(),"3-  $it")
        }
    }

    fun fun3() {
        val obs = Observable.zip<Int,Long,Int>(Observable.fromIterable(listOf(1,2,3,4,5,6,7,8,9)),
            Observable.interval(700,TimeUnit.MILLISECONDS),
            BiFunction<Int,Long,Int>{s1,s2->
            s1
        }).subscribeOn(Schedulers.computation())
            .observeOn(Schedulers.io())

        val pub = AsyncSubject.create<Int>()
        obs.subscribe(pub)


        pub.subscribe {
            Log.e(tag(),"1-  $it")
        }
        Thread.sleep(4000)

        pub.subscribe {
            Log.e(tag(),"2-  $it")
        }



    }


}