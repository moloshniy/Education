package com.example.education

import android.util.Log
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class JobStacter : CoroutineScope {

    private val job = Job()
    private lateinit var parentJob:Job
    private lateinit var childJob1:Job
    private lateinit var childJob2:Job

    private val exHandler = CoroutineExceptionHandler{c,e->
        Log.e("qqq","exception handled")
    }

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Default + exHandler

    fun start() {
         parentJob = launch {

                 childJob1 = launch(parentJob) {
                     logs("child1")

                 }

                 childJob2 = launch(parentJob) {
                     logs("child2", true)
                 }
             Log.e("qqq", " p c  = ${parentJob.children}")

             logs("parentJob")
         }

    }

    suspend fun logs(name: String,ex:Boolean = false) {
        repeat(5) {
            delay(1500)
            Log.e("qqq", name)
            if (ex && it==1) throw Exception()
        }
    }
}