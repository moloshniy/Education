package com.example.education.decorator2

import android.util.Log

class PizzaSouceDecorator2(private val pizza2: Pizza2, private val souce:String): PizzaDecorator2(pizza2) {

    override fun create() {
        super.create()
        Log.e("qqq", souce)
    }

}
fun Pizza2.addSouce(souce:String): Pizza2 {
    return PizzaSouceDecorator2(this, souce)
}

