package com.example.education.memento

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.education.R

class MementoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_memento)

        val originator = Originator()
        originator.state = "IronMan"
        var memento = originator.createMemento()
        val caretaker = Caretaker()
        caretaker.addMemento(memento)

        originator.state = "AnotherState"
        memento = originator.createMemento()

        caretaker.addMemento(memento)

        originator.state = "ThirdState"
        memento = originator.createMemento()
        caretaker.addMemento(memento)


        memento = caretaker.getMemento(1)
        originator.setMemento(memento)
        Log.e("qqq", originator.state)

        memento = caretaker.getMemento(0)
        originator.setMemento(memento)
        Log.e("qqq", originator.state)


    }
}
