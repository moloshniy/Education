package com.example.education

import android.util.Log
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

/** IF we have Hierarhy if
        Job 1-1
        /
    Job 1
   /     \
Job        Job 1-2
    \
     \      Job 2-1
      \   /
       Job 2
        \
        Job 2-2

If we have crash in any job and have Exception handler in main Job
 Every job will crash !!

 Если ошибка случилась в 1-2   джобе   то все остальные джобы тоже прекратят работу

2020-03-23 11:17:53.959 2389-2469/com.example.education E/qqq: child - 1.2
2020-03-23 11:17:53.959 2389-2467/com.example.education E/qqq: child - 1.1
2020-03-23 11:17:53.959 2389-2467/com.example.education E/qqq: child - 2.1
2020-03-23 11:17:54.953 2389-2469/com.example.education E/qqq: child - 2.2
2020-03-23 11:17:54.956 2389-2467/com.example.education E/qqq: exception handled


 */

class JobAndExceptionHanlder : CoroutineScope {

    private val job = Job()
    private lateinit var parentJob: Job
    private lateinit var childJob1: Job
    private lateinit var childJob1_1: Job
    private lateinit var childJob1_2: Job
    private lateinit var childJob2: Job
    private lateinit var childJob2_1: Job
    private lateinit var childJob2_2: Job

    private val exHandler = CoroutineExceptionHandler { c, e ->
        Log.e("qqq", "exception handled")
    }

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Default + exHandler

    fun start() {
        parentJob = launch {

            childJob1 = launch {

                childJob1_1 = launch {
                    while (isActive) {
                        delay(2000)
                        Log.e("qqq", "child - 1.1")

                    }
                }

                childJob1_2 = launch {
                    while (isActive) {
                        delay(2000)
                        Log.e("qqq", "child - 1.2")

                    }
                }
            }

            childJob2 = launch {

                childJob2_1 = launch {
                    while (isActive) {
                        delay(2000)
                        Log.e("qqq", "child - 2.1")

                    }
                }

                childJob2_2 = launch {
                    while (isActive) {
                        delay(3000)
                        Log.e("qqq", "child - 2.2")

                        throw Exception()
                    }
                }
            }

        }
    }
}