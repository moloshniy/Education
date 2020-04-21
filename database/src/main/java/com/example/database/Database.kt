package com.example.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [MoviesEntity::class], version = 0, exportSchema = false)
abstract class Database : RoomDatabase(){
    abstract val filmDao: Dao
}