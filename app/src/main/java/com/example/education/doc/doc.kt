package com.example.education.doc

/** concat(): operator concatenate two or more observables in such a way
 * that it acts like single observable. All items of each observable are emitted sequentially as passed
 * in parameter (concat(onservable1, obvervable2,...)).
 *
 * filter(): operator accepts a predicate that determine which items to filter out.
 * In case of concat() here it is being applied to a list returned by each executed
 * observable to check if data exists or is up to date.
 *
 *
 *first(): operator takes only first emitted item and rejects other emitted values.
 * It takes a default value as a parameter. In case no items emitted by source observable,
 * it emits that default value.
 *
 *
 *onError() вызывается вне зависимости от того, когда было выброшено исключение.
 *Операторы не обязаны обрабатывать исключения.
 * Обработка ошибок, возникающих в любом месте цепочки Observables становится задачей Subscriber, т.к.
 * каждое исключение следует напрямую в onError().
 *
 *
 *
 *
 * .timeout(MAX_SEND_TIMEOUT_MS, TimeUnit.MILLISECONDS)
 *Оператор timeout кидает исключение, если в течение заданного времени от Observable не поступило ни одного элемента.
 *
 *
 *
 * DoOnNext  - вызывается каждый раз когда приходит onNext
 *
 *onErrorResumeNext!!!
 *
 *
 *
 *
 *retry !!!
 *
 *
 * retryWhen
 *
 *
 *
 *
 * take   -  выбирает первые  элементы   take(5) - первые 5 элементов последовательности
 *
 *
 *
 *
 * delay
 *
 *
 *
 * range
 *
 *
 *
 *
 *
 *
 * zip - >  соединяет  источники  111, 222, 333  итд пока один из источников не  пошел onComplite  - тогда цепочка  прервется
 *
 *
 *
 *comibeLatest  - >  как только  получает значение из одного из изсточников тут же пересчитывает конечный обьект
 *
 *  Observable.combineLatest(s1, s2, s3, Function3<Int, String, String, String> { t1, t2, t3 ->
        "$t1 $t2 $t3"
        }).subscribe {
        Log.e(tag(), "it = $it")
    }
 *
 * 2020-03-30 17:31:26.432 15902-15961/com.example.education E/com.example.education.RxMain: it = 1 a
2020-03-30 17:31:26.792 15902-15960/com.example.education E/com.example.education.RxMain: it = 2 a
2020-03-30 17:31:27.605 15902-15960/com.example.education E/com.example.education.RxMain: it = 3 a
2020-03-30 17:31:27.684 15902-15961/com.example.education E/com.example.education.RxMain: it = 3 b
2020-03-30 17:31:28.417 15902-15960/com.example.education E/com.example.education.RxMain: it = 4 b
2020-03-30 17:31:28.936 15902-15961/com.example.education E/com.example.education.RxMain: it = 4 c
2020-03-30 17:31:29.230 15902-15960/com.example.education E/com.example.education.RxMain: it = 5 c
2020-03-30 17:31:30.041 15902-15960/com.example.education E/com.example.education.RxMain: it = 6 c
2020-03-30 17:31:30.189 15902-15961/com.example.education E/com.example.education.RxMain: it = 6 d
2020-03-30 17:31:30.853 15902-15960/com.example.education E/com.example.education.RxMain: it = 7 d
2020-03-30 17:31:31.665 15902-15960/com.example.education E/com.example.education.RxMain: it = 8 d
2020-03-30 17:31:32.476 15902-15960/com.example.education E/com.example.education.RxMain: it = 9 d
2020-03-30 17:31:32.477 15902-15960/com.example.education E/com.example.education.RxMain: complete
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *  private val list1 = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
 *  fun l1():Observable<Int> {
        return  Observable.fromIterable(list1).flatMap{
           val d = Random.nextLong(1000)
           Observable.just(it).delay(d, TimeUnit.MILLISECONDS)
        }
    }
 *
 *
 *
 * flatMap - >
 *
 * 2020-03-30 17:51:10.859 17054-17103/com.example.education E/com.example.education.RxMain: it = 8
2020-03-30 17:51:14.860 17054-17103/com.example.education E/com.example.education.RxMain: it = 2
2020-03-30 17:51:18.862 17054-17103/com.example.education E/com.example.education.RxMain: it = 9
2020-03-30 17:51:22.864 17054-17103/com.example.education E/com.example.education.RxMain: it = 3
2020-03-30 17:51:26.867 17054-17103/com.example.education E/com.example.education.RxMain: it = 1
2020-03-30 17:51:30.868 17054-17103/com.example.education E/com.example.education.RxMain: it = 6
2020-03-30 17:51:34.869 17054-17103/com.example.education E/com.example.education.RxMain: it = 7
2020-03-30 17:51:38.871 17054-17103/com.example.education E/com.example.education.RxMain: it = 4
 *
 *
 * switchMap
 *
 *2020-03-30 17:51:18.862 17054-17103/com.example.education E/com.example.education.RxMain: it = 9
 *
 *
 *
 * concatMap
 *
 * 2020-03-30 18:05:57.440 17307-17367/com.example.education E/com.example.education.RxMain: it = 1
    2020-03-30 18:05:58.356 17307-17370/com.example.education E/com.example.education.RxMain: it = 2
    2020-03-30 18:05:58.540 17307-17367/com.example.education E/com.example.education.RxMain: it = 3
    2020-03-30 18:05:59.030 17307-17370/com.example.education E/com.example.education.RxMain: it = 4
    2020-03-30 18:05:59.696 17307-17367/com.example.education E/com.example.education.RxMain: it = 5
    2020-03-30 18:06:00.402 17307-17370/com.example.education E/com.example.education.RxMain: it = 6
    2020-03-30 18:06:00.895 17307-17367/com.example.education E/com.example.education.RxMain: it = 7
    2  020-03-30 18:06:01.724 17307-17370/com.example.education E/com.example.education.RxMain: it = 8
    2020-03-30 18:06:02.248 17307-17367/com.example.education E/com.example.education.RxMain: it = 9

 *
 *
 *
 *
 *
 *    example how to emit with delay ->
 *   return  Observable.zip(Observable.fromIterable(list1), Observable.interval(500,TimeUnit.MILLISECONDS),
BiFunction<Int,Long,Int>{s1,s2->
s1
})
 */