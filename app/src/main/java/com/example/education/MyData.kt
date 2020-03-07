package com.example.education

data class MyData(
    val id:Int,
     val name: String,
     val age:Int
){
    override fun equals(other: Any?): Boolean {
        return super.equals(other)
    }
}