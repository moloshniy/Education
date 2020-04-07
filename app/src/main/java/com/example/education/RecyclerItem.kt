package com.example.education

import androidx.recyclerview.widget.RecyclerView
import kotlin.reflect.KClass

interface RecyclerItem {
    fun getType():Int

}