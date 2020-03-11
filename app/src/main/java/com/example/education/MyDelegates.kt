package com.example.education

import android.view.View
import android.widget.TextView
import androidx.lifecycle.LifecycleOwner

fun <T: TextView>provideLazyLoad( initializer:()->T, init2:()->LifecycleOwner):MyLazy<T> {
    return MyLazy(initializer, init2)
}
