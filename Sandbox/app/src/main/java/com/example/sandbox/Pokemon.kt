package com.example.sandbox

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pokemons")
data class Pokemon(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val number: Int,
    val name: String,
    val typeName1: String,
    val typeName2: String,
    val imagePath: String? = null
)