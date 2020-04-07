package com.example.education.decorator

import android.util.Log

class PizzaSouceDecorator(private val pizza: Pizza, souce:String): PizzaDecorator(pizza) {

    override fun create() {
        super.create()
        Log.e("qqq", "Souce added ")
    }
}