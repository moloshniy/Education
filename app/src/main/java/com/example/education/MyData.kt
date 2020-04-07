package com.example.education

import androidx.recyclerview.widget.RecyclerView
import kotlin.reflect.KClass

class MyData:RecyclerItem {

    override fun getType(): Int {
        return 1
    }

}