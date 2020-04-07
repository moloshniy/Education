package com.example.education.decorator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.education.R
import com.example.education.decorator2.PizzaSouceDecorator2

class DecoratorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_decorator)

        val pizza = PizzaSouceDecorator(PizzaTopingDecorator(Pizza(),"toping"), "souce")

        pizza.create()

    }
}
