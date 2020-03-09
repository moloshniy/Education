package com.example.education

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class NotEvenDelegate<R,T:Int> : ReadWriteProperty<R,T> {
    var int:Int = 0

    override fun getValue(thisRef: R, property: KProperty<*>): T {
       return int as T
    }

    override fun setValue(thisRef: R, property: KProperty<*>, value: T) {
       if (value%2 == 0)
           int = value
    }
}