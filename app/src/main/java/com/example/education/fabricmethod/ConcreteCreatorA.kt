package com.example.education.fabricmethod

class ConcreteCreatorA:Creator() {
    override fun factoryMethod(): Product {
       return ConcreteProductA()
    }
}