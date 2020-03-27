package com.example.education

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.education.database.DataBaseSource
import com.example.education.server.ServerSource
import io.reactivex.rxjava3.core.Observable
import tag


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
    }

    fun getUser(view: View) {
        //getUsersFromServer()
        getUserFromDBIfNotEmptyThenFromServer()
    }

    fun getUsersFromServer() {
        server.getAllPeoples().subscribe({
        }, {
            Log.e(tag(), "$it")
        })
    }

    fun getUserFromDBIfNotEmptyThenFromServer() {
        Observable.concat(database.getAllPeoples(), server.getAllPeoples())
            .filter { it.isNotEmpty() }
            .first(emptyList())
            .subscribe({
                Log.e(tag(), "$it")
            },{
            throw Exception()
        })

    }

    fun removeLastFromDB(view: View) {}
}

