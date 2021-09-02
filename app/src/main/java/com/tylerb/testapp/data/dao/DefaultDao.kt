package com.tylerb.testapp.data.dao

import androidx.room.*
import com.tylerb.testapp.data.model.Pokemon
import kotlinx.coroutines.flow.Flow

@Dao
interface DefaultDao {

    @Query("SELECT * FROM pokemon")
    fun getAll(): Flow<List<Pokemon>>

    @Query("SELECT * FROM pokemon WHERE id = :id")
    fun getById(id: Int): Flow<Pokemon>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg pokemon: Pokemon)

    @Delete
    suspend fun delete(pokemon: Pokemon)

    @Query("DELETE FROM pokemon WHERE id = :id")
    suspend fun deleteById(id: Int)


}