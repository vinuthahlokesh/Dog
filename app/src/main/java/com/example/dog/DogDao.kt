package com.example.dog

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
@Dao
interface DogDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertData(data: Dogdata)

    @Query("SELECT * FROM dogdata")
    fun readAll(): List<Dogdata>

    @Query("SELECT * FROM dogdata WHERE name IN (:name)")
    fun readByName(name: String): List<Dogdata>


}