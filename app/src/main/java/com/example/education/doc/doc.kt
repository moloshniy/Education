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
 *onErrorResumeNext!!!
 *
 *
 *
 *
 *retry !!!
 *
 *
 */