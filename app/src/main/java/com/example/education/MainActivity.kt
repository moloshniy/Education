package com.example.education

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.education.coldobservables.CallableExample
import com.example.education.coldobservables.ObservableExample
import com.example.education.database.DataBaseSource
import com.example.education.examples.SearchActivity
import com.example.education.hotobservables.ConnectableObserverExample
import com.example.education.hotobservables.PublishSubjectExample
import com.example.education.operators.OperatorsExample1
import com.example.education.server.ServerSource
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.ObservableSource
import tag


//Simple example of using ClosedRange Interface
//
class MainActivity : AppCompatActivity() {
    private val server: ServerSource =
        ServerSource()
    private val database: DataBaseSource =
        DataBaseSource()
var q: ConnectableObserverExample = ConnectableObserverExample()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       // q.start()
       startActivity( Intent(this, SearchActivity::class.java))
        // ObservableExample().start()


//        BackPreasure1().start()

//        System.setProperty("rx2.buffer-size", "1")
//        val observable: Observable<Int> = Observable.just(1, 2, 3, 4, 5, 6, 7)
//
//        observable.map(Function<Int, Int> {
//            return@Function it + 1
//        })
//
//        observable.flatMap(Function<Int, ObservableSource<Int>> {
//            Observable.just(it)
//        })
//
//        observable.flatMap {
//            Observable.just(it)
//        }
//
//        val coldObservable = Observable.create(ObservableOnSubscribe<Int> {
//            repeat(1000000) { i ->
//                it.onNext(i)
//            }
//
//            Log.e(tag() + "obs", "obs-complite")
//            it.onComplete()
//        }).subscribeOn(Schedulers.computation())
//            .observeOn(Schedulers.io())
//
//        val connectable:ConnectableObservable<Int> = coldObservable.publish()
//
//        connectable.subscribe {
//            Thread.sleep(2000)
//               Log.e(tag() + "subs", "subs ${Thread.currentThread().name}  $it")
//        }
//        connectable.connect()

        //Subject
        //AsyncSubject   https://medium.com/@mohitsharma_16765/rxsubjects-cold-and-hot-observables-connectableobservable-6ab0f3020876
        // BehaviourSubject
        //PublishSubject - default



//        Observable .create(ObservableOnSubscribe<Int> {
//            repeat(20000000) { i ->
//                it.onNext(i)
//            }
//            Log.e(tag() + "obs","obs-complite")
//            it.onComplete()
//        }).subscribeOn(Schedulers.computation())
//            .observeOn(Schedulers.io())
//
//
//            .subscribe ({
//                Thread.sleep(2000)
//                Log.e(tag() + "subs", "subs ${Thread.currentThread().name}  $it")
//            },{
//                Log.e(tag(), " THOWWW")
//                throw it
//            },{
//                Log.e(tag(),"subs-complite")
//            })

//        Observable.range(1, 1000_000_000)
//            .observeOn(ComputationScheduler())
//            .subscribeOn(SingleScheduler())
//            .subscribe {
        //                Thread.sleep(1000)
//                Log.e(tag(), "${Thread.currentThread().name}  $it")
//            }

    }

    fun getUser(view: View) {
        //getUsersFromServer()
        //getUserFromDBIfNotEmptyThenFromServer()

        RxMain().start()


    }

    fun getUsersFromServer() {
        server.getAllPeoples().subscribe({
        }, {
            Log.e(tag(), "$it")
        })
    }

    fun getListString() = listOf("a", "b", "c", "d")

    fun getUserFromDBIfNotEmptyThenFromServer() {
        Observable.concat(database.getAllPeoples(), server.getAllPeoples())
            .filter { it.isNotEmpty() }
            .first(emptyList())
            .subscribe({
                Log.e(tag(), "$it")
            }, {
                throw Exception()
            })
    }

    fun getUserFromServerAndTheUserDetailsUsingUser() {
        server.getAllPeoples()
            .flatMap { Observable.fromIterable(it) }
            .flatMap({ person -> server.getPersonDetails(person) },
                { person, personDetails ->
                    person.copy(details = personDetails)
                })
            .subscribe()
    }

    fun removeLastFromDB(view: View) {}
}

