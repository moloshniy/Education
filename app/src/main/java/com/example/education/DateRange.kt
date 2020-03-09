package com.example.education

class DateRange(override val endInclusive: Date,
                override val start: Date) :
    ClosedRange<Date>{

    override fun contains(value: Date): Boolean {
       return value > start && value < endInclusive
    }

    override fun isEmpty(): Boolean {
      return  start > endInclusive
    }
}