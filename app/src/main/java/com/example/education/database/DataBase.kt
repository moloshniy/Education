package com.example.education.database

import com.example.education.entity.Person
import io.reactivex.rxjava3.core.Observable

import kotlin.collections.ArrayList
import kotlin.random.Random

class DataBase {
    private val dbList:MutableList<Person> = ArrayList()

    fun saveToDb(person: Person){
        Thread.sleep(Random.nextLong(1000))
        dbList.add(person)
    }

    fun getPersons(): Observable<List<Person>> {
      //  Thread.sleep(Random.nextLong(1000))
        return Observable.just(dbList)
    }
}