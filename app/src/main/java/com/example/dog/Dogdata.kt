package com.example.dog

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "dogdata")
class Dogdata (
    @PrimaryKey @ColumnInfo(name = "Name") val name : String,


    @ColumnInfo(name = "breed")val breed : String,

    @ColumnInfo(name = "colour")val colour : String,

    @ColumnInfo(name = "age")val age : String


)