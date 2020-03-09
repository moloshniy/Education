package com.example.education

class Dates : Iterable<Date> {

    private val datesList: MutableList<Date> = ArrayList()

    override fun iterator(): Iterator<Date> {
        var currentPosition: Int = 0
        return object : Iterator<Date> {

            override fun hasNext(): Boolean {
                return datesList.size > currentPosition
            }

            override fun next(): Date {
                return datesList[currentPosition++]
            }
        }
    }

    fun addElement(date: Date) {
        datesList.add(date)
    }


}