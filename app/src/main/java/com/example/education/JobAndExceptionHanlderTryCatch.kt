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


 Если ошибка случилась в 1-2   джобе   и мы ее там же обработали  try  catch
- все продолжить рабоатть как и было

2020-03-23 11:24:26.492 2584-2661/com.example.education E/qqq: child - 1.2
2020-03-23 11:24:26.544 2584-2661/com.example.education E/qqq: child - 1.1
2020-03-23 11:24:26.545 2584-2661/com.example.education E/qqq: child - 2.1
2020-03-23 11:24:27.488 2584-2662/com.example.education E/qqq: child - 2.2
2020-03-23 11:24:27.488 2584-2662/com.example.education E/qqq: Local exception
2020-03-23 11:24:28.494 2584-2662/com.example.education E/qqq: child - 1.2
2020-03-23 11:24:28.547 2584-2662/com.example.education E/qqq: child - 1.1
2020-03-23 11:24:28.547 2584-2662/com.example.education E/qqq: child - 2.1
2020-03-23 11:24:30.490 2584-2661/com.example.education E/qqq: child - 2.2
2020-03-23 11:24:30.490 2584-2661/com.example.education E/qqq: Local exception
2020-03-23 11:24:30.495 2584-2661/com.example.education E/qqq: child - 1.2
2020-03-23 11:24:30.548 2584-2661/com.example.education E/qqq: child - 1.1
2020-03-23 11:24:30.548 2584-2661/com.example.education E/qqq: child - 2.1
2020-03-23 11:24:32.500 2584-2662/com.example.education E/qqq: child - 1.2
2020-03-23 11:24:32.551 2584-2662/com.example.education E/qqq: child - 1.1
2020-03-23 11:24:32.551 2584-2662/com.example.education E/qqq: child - 2.1
2020-03-23 11:24:33.492 2584-2661/com.example.education E/qqq: child - 2.2
2020-03-23 11:24:33.492 2584-2661/com.example.education E/qqq: Local exception


 */

class JobAndExceptionHanlderTryCatch : CoroutineScope {

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
                        try {
                            throw Exception()
                        }
                        catch (e:java.lang.Exception){
                            Log.e("qqq","Local exception")
                        }

                    }
                }
            }

        }
    }
}