package com.example.dog

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Dogdata::class],version = 1,exportSchema = false)
abstract class DogDatabase:RoomDatabase() {
    abstract fun dogDao() : DogDao
}