package com.example.facturas_iberdrola.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.facturas_iberdrola.domain.Facturas2

@Entity(tableName = "facturas_table")
data class Entity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int = 0,
    @ColumnInfo(name = "descEstado")val descEstado: String,
    @ColumnInfo(name = "importeOrdenacion")val importeOrdenacion: Double,
    @ColumnInfo(name = "fecha")val fecha: String
)

fun Facturas2.toDatabase() = Entity(
    descEstado = descEstado,
    importeOrdenacion = importeOrdenacion,
    fecha = fecha)