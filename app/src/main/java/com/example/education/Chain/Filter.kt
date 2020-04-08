package com.example.education.Chain

abstract class Filter {
    var filter:Filter? = null
    var q:Int = 0

    abstract fun filter(q:Int)

    fun setNext(filter:Filter){
        this.filter = filter
    }
}