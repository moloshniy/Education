package com.example.education.server

import android.util.Log
import com.example.education.entity.Person
import com.example.education.server.errors.BadInternetConnectionException
import io.reactivex.rxjava3.core.Observable
import tag
import java.io.IOException
import java.lang.NullPointerException
import kotlin.random.Random

class ServerContainer {

    private val personList: MutableList<Person> = ArrayList()

    init {
        generatePersonList()
    }

    private fun generatePersonList() {
        for (i in 0..3) {
            personList.add(
                Person(
                    "server- $i",
                    i
                )
            )
        }
    }

    fun getAllPersonsRxObservable(): Observable<List<Person>> {
        return Observable.create {
         //  Thread.sleep(1500)
//            val i:Int = Random.nextInt(4)
//            Log.e(tag(),"$i")
//            when (i) {
//                0 -> {
//                    it.onNext(personList)
//                    it.onComplete()
//                }
//                1-> it.onError(IOException())
//                2-> it.onNext(null)
//                3-> it.onError(NullPointerException())
//            }
            it.onNext(personList)
            it.onComplete()
        }
    }
}