package com.example.education

import android.util.Log
import kotlinx.coroutines.*
import java.lang.Exception
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

class SupervisorJob_JobAndExceptionHanlder : CoroutineScope {

    private val job = Job()
    private val superVisorJob = SupervisorJob(job)
    private lateinit var parentJob: Job
    private lateinit var parentJob2: Job
    private lateinit var childJob1: Job
    private lateinit var childJob1_1: Job
    private lateinit var childJob1_2: Job
    private lateinit var childJob2: Job
    private lateinit var childJob2_1: Job
    private lateinit var childJob2_2: Job

    private val exHandler = CoroutineExceptionHandler { c, e ->
        Log.e("qqq", "exception handled")
    }

    private val exChildrenHandler = CoroutineExceptionHandler { c, e ->
        Log.e("qqq", "children exception handled")
    }

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Default

    fun start() {
        parentJob = launch() {

            childJob1 = launch() {

                childJob1_1 = launch() {
                    while (isActive) {
                        delay(2000)
                        Log.e("qqq", "child - 1.1")
                    }
                }

                childJob1_2 = launch {
                    while (isActive) {
                        delay(2000)
                        Log.e("qqq", "child - 1.2")
                        try {
                            throw Exception()
                        }catch (e:Exception){}
                    }
                }
            }

            childJob2 = launch(SupervisorJob(parentJob) + exChildrenHandler) {

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

                while (isActive) {
                    delay(2000)
                    Log.e("qqq", "Chilkd Job 2 - parent  is Active")
                }
            }

            while (isActive) {
                delay(2000)
                Log.e("qqq", "Parent is Active")
            }
        }

        parentJob2 = launch(exChildrenHandler) {
            while (isActive) {
                delay(3000)
                 Log.e("qqq", "Parent job 2 ")

            }
        }

    }
}
/**
 * if we start paren1 and paren2 on Scope with JOB!!
 * if  we have crash in children2-2  for example
 * then Every Coroutine  started with scope will stop
 * its mean paren2 will stop too
 *
 * 2020-03-23 11:58:55.407 4521-4591/com.example.education E/qqq: Parent job 2
2020-03-23 11:58:55.434 4521-4591/com.example.education E/qqq: child - 1.2
2020-03-23 11:58:55.435 4521-4591/com.example.education E/qqq: child - 2.1
2020-03-23 11:58:55.435 4521-4591/com.example.education E/qqq: child - 1.1
2020-03-23 11:58:56.422 4521-4590/com.example.education E/qqq: child - 2.2
2020-03-23 11:58:56.430 4521-4590/com.example.education E/qqq: exception handled
 *
 *IF we will use Scoope with supervisorJob!!  then  parent1 and all his children will stop
 * but parent2 will still working
 *
 * 2020-03-23 12:18:41.419 4703-4761/com.example.education E/qqq: child - 1.2
2020-03-23 12:18:41.420 4703-4761/com.example.education E/qqq: child - 2.1
2020-03-23 12:18:41.420 4703-4761/com.example.education E/qqq: child - 1.1
2020-03-23 12:18:41.420 4703-4761/com.example.education E/qqq: Parent job 2
2020-03-23 12:18:42.419 4703-4760/com.example.education E/qqq: child - 2.2
2020-03-23 12:18:42.425 4703-4760/com.example.education E/qqq: exception handled
2020-03-23 12:18:43.422 4703-4760/com.example.education E/qqq: Parent job 2
2020-03-23 12:18:45.424 4703-4760/com.example.education E/qqq: Parent job 2
2020-03-23 12:18:49.429 4703-4760/com.example.education E/qqq: Parent job 2
2020-03-23 12:18:51.431 4703-4760/com.example.education E/qqq: Parent job 2
2020-03-23 12:18:59.442 4703-4760/com.example.education E/qqq: Parent job 2
 *
 *
 *
 *
 *
children-1-1
/
child1
/        \
/         children 1-2
/
parent1         child2-1
/       \       /
/          child2
/                 \
/                    child2-2
/
scope
\
\
\
\
\parent2

 */