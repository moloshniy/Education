package com.example.education

import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.OnLifecycleEvent

class MyLazy<T : TextView> constructor(
    private val initializer: () -> T,
    private val init2: () -> LifecycleOwner
) : Lazy<T>, LifecycleObserver {


    private var t: T? = null

    override fun isInitialized(): Boolean {
        return t != null
    }

    override val value: T
        get() {
            return if (!isInitialized()) {
                init2.invoke().lifecycle.addObserver(this)
                t = initializer.invoke()
                t as T
            } else {
                t as T
            }
        }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    private fun onCreate() {

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private fun onDestroy() {
       Log.e("QQQ", "ON DESTORY")
        t = null
    }

}