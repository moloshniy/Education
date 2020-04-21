package com.example.database

import androidx.room.Dao
import androidx.room.Database
import androidx.room.Insert

@Dao
interface Dao {

    @Insert()
    fun insertFilm()
}