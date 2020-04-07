package com.example.education.memento

class Caretaker {
    private val stateList = ArrayList<Memento>()

    fun addMemento(m:Memento){
        stateList.add(m)
    }

    fun getMemento(index:Int):Memento{
        return stateList.get(index)
    }
}