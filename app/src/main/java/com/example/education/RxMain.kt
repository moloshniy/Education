package com.example.education

import android.util.Log
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.functions.BiFunction
import io.reactivex.rxjava3.functions.Function3
import io.reactivex.rxjava3.internal.schedulers.ComputationScheduler
import io.reactivex.rxjava3.internal.schedulers.IoScheduler
import tag
import java.util.concurrent.TimeUnit
import kotlin.concurrent.thread
import kotlin.random.Random

class RxMain {

    private val list1 = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    private val list2 = listOf("a", "b", "c", "d")
    private val list3 = listOf("blue", "red","")


    fun l1():Observable<Int> {
        return  Observable.fromIterable(list1).concatMap{
           val d = Random.nextLong(1000)
            Observable.just(it).delay(d, TimeUnit.MILLISECONDS)
        }
    }

    fun l2():Observable<String> {
        return  Observable.zip(Observable.fromIterable(list2), Observable.interval(Random.nextLong(1500),TimeUnit.MILLISECONDS),
            BiFunction<String,Long,String>{s1,s2->
                s1
            })
    }

    fun l3():Observable<String> {
        return  Observable.zip(Observable.fromIterable(list3), Observable.interval(Random.nextLong(1500),TimeUnit.MILLISECONDS),
            BiFunction<String,Long,String>{s1,s2->
                s1
            })
    }

    fun start() {
    list1.map {

    }

        val s1 = l1()
        val s2 = l2()
        val s3 = l3()

        s1.subscribe {
                Log.e(tag(), "it = $it")
        }

//        Observable.combineLatest(s1, s2, s3, Function3<Int, String, String, String> { t1, t2, t3 ->
//            "$t1 $t2 $t3"
//        }).subscribe {
//            Log.e(tag(), "it = $it")
//        }

    }

}