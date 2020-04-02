package com.example.education.hotobservables

import android.util.Log
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.observables.ConnectableObservable
import io.reactivex.rxjava3.schedulers.Schedulers
import tag
import java.util.concurrent.TimeUnit


class ConnectableObserverExample {

    fun start() {
        // fun1() //- working as expected
        //fun2() // - почему приложение не падает ??
        /**
         * 2020-04-01 15:57:35.930 18004-18065/com.example.education E/qqqcom.example.education.hotobservables.ConnectableObserverExample: 0
        2020-04-01 15:57:36.934 18004-18065/com.example.education E/qqqcom.example.education.hotobservables.ConnectableObserverExample: 1
        2020-04-01 15:57:37.941 18004-18065/com.example.education E/qqqcom.example.education.hotobservables.ConnectableObserverExample: 2
        2020-04-01 15:57:38.944 18004-18065/com.example.education E/qqqcom.example.education.hotobservables.ConnectableObserverExample: 3
        2020-04-01 15:57:39.949 18004-18065/com.example.education E/qqqcom.example.education.hotobservables.ConnectableObserverExample: 4
        2020-04-01 15:57:40.950 18004-18065/com.example.education E/qqqcom.example.education.hotobservables.ConnectableObserverExample: 5
        2020-04-01 15:57:41.952 18004-18065/com.example.education E/qqqcom.example.education.hotobservables.ConnectableObserverExample: 6
         */

        fun3()
    }

    fun fun1() {
        val co: ConnectableObservable<Long> = Observable.interval(1, TimeUnit.SECONDS)
            .subscribeOn(Schedulers.computation())
            .publish()
        co.connect()
        Thread.sleep(4000)

        co.subscribe {
            Log.e(tag(), "$it")
        }
    }

    fun fun2() {
        val obs = Observable.create<Int> {
            repeat(5000000) { i ->
                it.onNext(i)
            }
        }.subscribeOn(Schedulers.computation())
            .observeOn(Schedulers.io())
        val conobs = obs.publish()

        conobs.connect()
        conobs.subscribe {
            Thread.sleep(1000)
            Log.e(tag(), "$it")
        }

        conobs.connect()
    }

    fun fun3() {
        val obs = Observable.create<Int> {
            repeat(1000000) { i ->
                it.onNext(i)
            }
        }.subscribeOn(Schedulers.computation())
            .observeOn(Schedulers.io())
        val obsnews = obs.publish().refCount()
        Thread.sleep(100)

        val dis1 = obsnews.subscribe {
            Log.e(tag(), "1 - $it")
        }

        Thread.sleep(100)
        val dis2 = obsnews.subscribe {
            Log.e(tag(), "2 - $it")
        }

        Thread.sleep(1500)
        dis1.dispose()
        dis2.dispose()
    }

}
