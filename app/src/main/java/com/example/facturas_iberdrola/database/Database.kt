package com.example.facturas_iberdrola.database

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [Entity::class], version = 1)
abstract class DatabaseFacturas : RoomDatabase() {

    abstract fun getFacturaDao():Dao
}