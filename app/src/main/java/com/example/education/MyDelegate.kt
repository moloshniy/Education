package com.example.education

import android.app.Activity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import java.lang.Exception
import kotlin.properties.Delegates

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class MyDelegate {

     fun<R:Activity,T:String> myDelegateInActivityForString():ReadWriteProperty<R,T>{
         return My2()
     }

    fun<R:Fragment,T:String> myDelegateInFragmentForString():ReadWriteProperty<R,T>{
        return My2()
    }

    fun<R,T> myDelegateInAnyForAny():ReadWriteProperty<R,T>{
        return My2()
    }
}
//if we want for Not Null property we should set
//class  My2<R:Any,T:Any> : ReadWriteProperty<R,T>
class  My2<R,T> : ReadWriteProperty<R,T> {
    private var t:T? = null

    override fun getValue(thisRef: R, property: KProperty<*>): T {
        return t ?: throw Exception()
    }

    override fun setValue(thisRef: R, property: KProperty<*>, value: T) {
        t= value
    }
}


private class MyDel1<T : Any>() : ReadWriteProperty<Any?, T> {
    private var value: T? = null

    public override fun getValue(thisRef: Any?, property: KProperty<*>): T {
        return value ?: throw IllegalStateException("Property ${property.name} should be initialized before get.")
    }

    public override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        this.value = value
    }
}