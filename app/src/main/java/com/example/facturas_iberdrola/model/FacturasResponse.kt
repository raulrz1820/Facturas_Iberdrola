package com.example.facturas_iberdrola.model

data class FacturasResponse(
    var numFacturas: Double,
    val facturas: List<Facturas>
)
