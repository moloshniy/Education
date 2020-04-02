package com.example.education.examples

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.SearchView
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import tag
import java.util.concurrent.TimeUnit

class SearchActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        SearhObservable().getObservableFromSearchView(SearchView(this))
            .debounce(300,TimeUnit.MILLISECONDS)
            .filter {
                it.isEmpty()
            }
            .switchMap {
                Thread.sleep(1000)
                Observable.just(it)
            }
            .distinctUntilChanged()
            .subscribeOn(Schedulers.computation())
            .subscribe {
                Log.e(tag(),it)
            }
    }
}
