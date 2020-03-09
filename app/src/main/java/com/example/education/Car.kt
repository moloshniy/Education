package com.example.education

class Car private constructor(carBuilder: CarBuilder) {

    private var wheel: Int = 0
    private var carColor: String = ""
    private var carCost: Int = 0

    init {
        wheel = carBuilder.wheel
        carColor = carBuilder.carColor
        carCost = carBuilder.carCost
    }


    class CarBuilder() {


        internal var wheel: Int = 0
        internal var carColor: String = ""
        internal var carCost: Int = 0

        fun addWheel(wheel: Int): CarBuilder {
            this.wheel = wheel
            return this
        }

        fun addCarColor(color: String): CarBuilder {
            this.carColor = color
            return this
        }

        fun build(): Car {
            return Car(this)
        }
    }
}




