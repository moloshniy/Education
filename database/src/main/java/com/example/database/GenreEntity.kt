package com.example.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class GenreEntity(
    @PrimaryKey val id:Long,
    val genre:String
)