package com.example.education.server

import android.util.Log
import com.example.education.entity.Person
import com.example.education.entity.PersonDetails
import com.example.education.server.errors.BadInternetConnectionException
import com.example.education.server.errors.ServerException
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.internal.schedulers.IoScheduler
import tag
import java.io.IOException
import java.io.UncheckedIOException
import java.lang.NullPointerException
import java.util.concurrent.TimeUnit


class ServerSource {
    private val serverContainer: ServerContainer =
        ServerContainer()
    //send request
    fun getAllPeoples(): Observable<List<Person>> {
        return serverContainer.getAllPersonsRxObservable()
            .subscribeOn(IoScheduler())
            //.observeOn(AndroidSchedulers)
           // .map { it.filter { person -> person.age % 2 == 0 } }
            .onErrorResumeNext {
                when (it) {
                    is IOException -> {
                        Log.e(tag(), "ServerException")
                        Observable.error<List<Person>>(ServerException())
                    }
                    is NullPointerException -> {
                        Log.e(tag(), "BadConnetionExcample")
                        Observable.error<List<Person>>(BadInternetConnectionException())
                    }
                    else -> Observable.error<List<Person>>(NotImplementedError())
                }
            }
            .retry(3) {
                Log.e(tag(), "retry  +  $it")
                it is BadInternetConnectionException
            }
    }

    fun getPersonDetails(person:Person): Observable<PersonDetails> {
            return serverContainer.getPersonDetails(person)
    }
}