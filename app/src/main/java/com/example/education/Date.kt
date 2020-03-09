package com.example.education

import java.time.Month

class Date (val year:Int, val month: Int) :Comparable<Date> {

    override fun compareTo(other: Date): Int {
        if (this.year > other.year ) return -1
        if (this.year < other.year ) return 1
        if (this.month > other.month ) return 1
        if (this.month < other.month ) return 1
        return 0
    }
    operator fun rangeTo(other: Date) {
        DateRange(other,this)
    }
}