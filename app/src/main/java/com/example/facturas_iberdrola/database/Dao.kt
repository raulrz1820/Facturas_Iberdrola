package com.example.facturas_iberdrola.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.facturas_iberdrola.model.Facturas


@Dao
interface Dao {
    @Query("SELECT * FROM facturas_table")
    suspend fun getAllFacturas():List<Entity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(facturas:List<Entity>)

    @Query("DELETE FROM facturas_table")
    suspend fun deleteAllFacturas()
}