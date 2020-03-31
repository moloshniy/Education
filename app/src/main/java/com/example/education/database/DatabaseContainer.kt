package com.example.education.database

import android.util.Log
import com.example.education.entity.Person
import com.example.education.entity.PersonDetails
import io.reactivex.rxjava3.core.Observable
import tag
import kotlin.random.Random

class DatabaseContainer {

    private val personList: MutableList<Person> = ArrayList()

    init {
        generatePersonList()
    }

    private fun generatePersonList() {
        for (i in 0..3) {
            personList.add(
                Person(
                    "Database- $i",
                    i,
                    PersonDetails()
                )
            )
        }
    }

    fun getAllPersonsRxObservable(): Observable<List<Person>> {
        return Observable.create {
            Thread.sleep(1500)
            val i: Int = Random.nextInt(4)
            it.onNext(personList)
            it.onComplete()
        }
    }
}
