package com.example.education.decorator

import android.util.Log
import com.example.education.decorator2.Pizza2
import com.example.education.decorator2.PizzaDecorator2

class PizzaTopingDecorator2(private val pizza2: Pizza2, private val toping:String): PizzaDecorator2(pizza2) {

    override fun create() {
        super.create()
        Log.e("qqq", toping)
    }


}
fun Pizza2.addToping(souce:String): Pizza2 {
    return PizzaTopingDecorator2(this, souce)
}