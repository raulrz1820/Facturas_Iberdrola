package com.example.facturas_iberdrola.domain

import com.example.facturas_iberdrola.database.Entity
import com.example.facturas_iberdrola.model.Facturas

data class Facturas2 (
    val descEstado: String,
    val importeOrdenacion: Double,
    val fecha: String
        )
fun Facturas.toDomain() = Facturas2(descEstado, importeOrdenacion, fecha)
fun Entity.toDomain() = Facturas2(descEstado, importeOrdenacion, fecha)