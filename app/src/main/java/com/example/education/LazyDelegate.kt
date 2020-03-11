package com.example.education

import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.OnLifecycleEvent
import kotlin.properties.ReadOnlyProperty
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class LazyDelegate<R:Fragment,T:View> constructor(private val lifecycleOwner: LifecycleOwner, private val initializer:()->T): ReadOnlyProperty<R,T>, LifecycleObserver {
   private var view:T? = null

    override fun getValue(thisRef: R, property: KProperty<*>): T {
       return view?: throw Exception ("WHY NULL CANT BE !")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    private fun onCreate(){
        lifecycleOwner.lifecycle.addObserver(this)
        view = initializer.invoke()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private fun onDestroy(){
        lifecycleOwner.lifecycle.removeObserver(this)
        view = null
    }

}