package com.example.education.server

import com.example.education.entity.Person
import com.example.education.entity.PersonDetails
import io.reactivex.rxjava3.core.Observable

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
                    i,
                    PersonDetails()
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

    fun getPersonDetails(person: Person): Observable<PersonDetails> {
        return Observable.just(PersonDetails(person.age * 10))
    }


}