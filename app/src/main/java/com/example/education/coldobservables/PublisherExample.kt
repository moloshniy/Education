package com.example.education.coldobservables

import io.reactivex.rxjava3.core.Observable

/**Observable.fromPublisher
This operator serves the same purpose as Observable.create but is readily
compatible with Reactive-Streams’ Publisher type.
It is generally used for potentially unbounded sequences.
*/

class PublisherExample {

    fun fun1(){
        Observable.fromPublisher<String>{
            while (true) {
                it.onNext("I am infinite");
            }
        }
    }
}