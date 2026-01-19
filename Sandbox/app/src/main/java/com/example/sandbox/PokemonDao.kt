package com.example.sandbox

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface PokemonDao {
    @Insert
    suspend fun insert(pokemon: Pokemon)

    @Query("SELECT * FROM pokemons ORDER BY id ASC")
    fun getAllPokemons(): Flow<List<Pokemon>>

    @Query("DELETE FROM pokemons")
    suspend fun deleteAllPokemons()
}
