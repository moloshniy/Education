package com.example.education.decorator

import android.util.Log

class PizzaTopingDecorator(private val pizza: Pizza, toping:String): PizzaDecorator(pizza) {

    override fun create() {
        super.create()
        Log.e("qqq", "toping added ")
    }
}