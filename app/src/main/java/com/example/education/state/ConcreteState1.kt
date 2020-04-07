package com.example.education.state

import android.util.Log

class ConcreteState1 : State {
    override fun handle() {
      Log.e("qqq", "Handle 1 ")
    }
}