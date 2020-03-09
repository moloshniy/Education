package com.example.education

class Car3 private constructor(val builder: Car3Builder) {

    companion object {
        fun builder(init: Car3Builder.() -> Unit): Car3 {
            val c3b = Car3Builder()
            c3b.init()
            return c3b.build()
        }
    }

    class Car3Builder() {
        private var age: Int = 0
        private var name: Int = 0

        fun addAge(_age: Int) {
            age = _age
        }

        fun addName(_name: Int) {
            name = _name
        }

        fun build(): Car3 {
            return Car3(this)
        }
    }
}