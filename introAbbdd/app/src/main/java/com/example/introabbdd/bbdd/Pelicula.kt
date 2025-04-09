package com.example.introabbdd.bbdd

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "Peliculas")
data class Pelicula(
    @PrimaryKey(autoGenerate = true) var id:Int=0,
    @NonNull var titulo:String
){}