package com.example.education.examples

import android.widget.SearchView
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.subjects.PublishSubject

class SearhObservable {
    fun getObservableFromSearchView(search:SearchView):Observable<String>{
        val subject:PublishSubject<String> = PublishSubject.create()
        search.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.let {
                    subject.onNext(it)
                }
               return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                newText?.let {
                    subject.onNext(it)
                }
                return true
            }

        })
        return subject
    }
}