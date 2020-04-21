package com.example.database

import androidx.room.Entity

@Entity(primaryKeys = ["movieId","genreId"])
data class Movie_GenreEntity(
    val movieId:Long,
    val genreId:Int
)