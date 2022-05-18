package com.example.facturas_iberdrola.network

import com.example.facturas_iberdrola.model.Facturas
import com.example.facturas_iberdrola.model.FacturasResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface FacturasApi {
    @GET("/facturas")
    suspend fun getFacturas() : Response<FacturasResponse>
}