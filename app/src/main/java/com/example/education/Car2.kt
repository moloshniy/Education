package com.example.education

class Car2 private constructor(carBuilder: CarBuilder2) {

    fun getWheel():Int{
        return wheel
    }

   companion object CarBuilder2{

        internal var wheel: Int = 0
        internal var carColor: String = ""
        internal var carCost: Int = 0

        fun addWheel(wheel: Int): CarBuilder2 {
            this.wheel = wheel
            return this
        }

        fun addCarColor(color: String): CarBuilder2 {
            this.carColor = color
            return this
        }

        fun build(): Car2 {
            return Car2(this)
        }
    }
}