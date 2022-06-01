package com.example.facturas_iberdrola


import com.example.facturas_iberdrola.database.Dao
import com.example.facturas_iberdrola.database.Entity
import com.example.facturas_iberdrola.domain.Facturas2
import com.example.facturas_iberdrola.domain.toDomain
import com.example.facturas_iberdrola.model.Facturas
import com.example.facturas_iberdrola.model.FacturasResponse
import com.example.facturas_iberdrola.network.FacturasService
import javax.inject.Inject

class Repository @Inject constructor(
    private val api: FacturasService,
    private val facturaDao: Dao
) {

    suspend fun getAllFacturasFromApi(): List<Facturas2> {
        val response: List<Facturas> = api.getFacturas()
        return response.map { it.toDomain() }
    }

    suspend fun getAllFacturasFromDatabase():List<Facturas2>{
        val response: List<Entity> = facturaDao.getAllFacturas()
        return response.map { it.toDomain() }
    }

    suspend fun insertFacturas(facturas:List<Entity>){
        facturaDao.insertAll(facturas)
    }

    suspend fun clearFacturas(){
        facturaDao.deleteAllFacturas()
    }
}