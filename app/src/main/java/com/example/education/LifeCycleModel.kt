package com.example.education

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.OnLifecycleEvent

class LifeCycleModel(private val lifeCycle:Lifecycle) : LifecycleObserver {

    init {
    lifeCycle.addObserver(this)
}

   @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
   private fun onPause(){
       Log.e("QQQ","On Pause")
   }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    private fun onCreate(){
        Log.e("QQQ","On Create")
    }

}