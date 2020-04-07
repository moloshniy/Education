package com.example.education.fabricmethod

class ConcreteCreatorB:Creator() {
    override fun factoryMethod(): Product {
        return ConcreteProductB()
    }
}