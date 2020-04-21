package com.example.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class MoviesEntity(
    @PrimaryKey(autoGenerate = true) val id: Long,
    val name: String,
    val duration:Int
)