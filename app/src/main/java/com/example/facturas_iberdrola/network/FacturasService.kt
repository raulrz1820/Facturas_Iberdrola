package com.example.facturas_iberdrola.network

import com.example.facturas_iberdrola.model.Facturas
import com.example.facturas_iberdrola.model.FacturasResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class FacturasService @Inject constructor(private val api:FacturasApi){

    suspend fun getFacturas(): List<Facturas> {
        return withContext(Dispatchers.IO) {
            val response = api.getFacturas()
            response.body()?: emptyList()
            //Este fallo no se como solucionarlo, se que el fallo puede estar en haber creado
            //ambas funciones, tanto en el Main como en FacturasService, pero he hecho lo que
            //he podido y no se como solucionarlo

        }
    }
}