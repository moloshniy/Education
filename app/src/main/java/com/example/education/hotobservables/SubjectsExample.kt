package com.example.education.hotobservables

import android.util.Log
import io.reactivex.rxjava3.processors.PublishProcessor
import io.reactivex.rxjava3.schedulers.Schedulers
import tag


class SubjectsExample {

    fun start() {
        val source = PublishProcessor.create<Int>()
        Log.e(tag(),"v = 123")
        source
            .observeOn(Schedulers.computation())
            .subscribe(
                {
                    Log.e(tag(),"v = $it")
                }
            ) {
                it.printStackTrace()
            }

        for (i in 0..999999) {
            source.onNext(i)
        }
    }
}
