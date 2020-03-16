package com.example.education

import android.app.Activity
import android.database.DatabaseUtils
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import kotlin.properties.ReadOnlyProperty
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class ActivityBinding<out T : ViewDataBinding>(@LayoutRes private val layoutRes: Int) :
    ReadOnlyProperty<Activity, T> {

    private var binding: T? = null

    override fun getValue(thisRef: Activity, property: KProperty<*>): T {
        return binding ?: createContentView(thisRef).also { binding = it }
    }

    private fun createContentView(activity: Activity): T {
        return DataBindingUtil.setContentView(activity, layoutRes)
    }

}