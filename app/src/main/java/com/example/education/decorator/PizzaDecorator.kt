package com.example.education.decorator

import com.example.education.decorator.Pizza

abstract class PizzaDecorator(private val pizza: Pizza) : Pizza() {

    override fun create(){
        pizza.create()
    }

}