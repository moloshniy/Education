package com.example.education

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rv = findViewById<RecyclerView>(R.id.recyclerview)
         val adapter = MyAdapter(this)
        rv.layoutManager = LinearLayoutManager(this,RecyclerView.VERTICAL,false)
        rv.adapter = adapter

        val l = listOf<MyData>(MyData(1,"1",1), MyData(2,"2",2), MyData(3,"33",3))

        adapter.setList(l)

        val handler = Handler()

        handler.postDelayed(Runnable {
            val m = listOf<MyData>(MyData(2,"7",7), MyData(3,"8",8),MyData(1,"1",1))
            adapter.setList(m)
        },4000)
    }


}
