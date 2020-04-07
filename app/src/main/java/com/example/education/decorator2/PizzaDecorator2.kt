package com.example.education.decorator2


abstract class PizzaDecorator2(private val pizza: Pizza2) : Pizza2() {

    override fun create(){
        pizza.create()
    }

}