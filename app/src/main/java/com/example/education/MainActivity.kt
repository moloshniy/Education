package com.example.education

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doOnTextChanged
import com.example.education.database.DataBaseSource
import com.example.education.server.ServerSource
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.functions.BiFunction
import io.reactivex.rxjava3.functions.Function3
import tag
import java.util.concurrent.TimeUnit


//Simple example of using ClosedRange Interface
//
class MainActivity : AppCompatActivity() {
    private val server: ServerSource =
        ServerSource()
    private val database: DataBaseSource =
        DataBaseSource()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val et = findViewById<EditText>(R.id.textview)
       val obs =  Observable.create<String> {
            val watcher = object: TextWatcher{
                override fun afterTextChanged(s: Editable?) {

                }

                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {

                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    it.onNext(s.toString())
                }

            }

            et.addTextChangedListener(watcher)
        }
        obs
            .debounce(1000,TimeUnit.MILLISECONDS)
            .throttleFirst()
            .subscribe{
            Log.e(tag(), it)
        }
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

    fun getListString() = listOf("a","b","c","d")

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

