package com.example.education.memento

class Originator {

    var state:String? = null

    fun setMemento(m:Memento){
         state = m.state
    }

    fun createMemento():Memento{
        return Memento(state!!)
    }
}