package com.example.education.database

import com.example.education.entity.Person
import io.reactivex.rxjava3.core.Observable

class DataBaseSource {
private val database: DataBase = DataBase()
    private val databaseContainer:DatabaseContainer = DatabaseContainer()

    fun getAllPeoples(): Observable<List<Person>> {
        return databaseContainer.getAllPersonsRxObservable()
    }

    fun savePerson(person: Person){
        database.saveToDb(person)
    }

}