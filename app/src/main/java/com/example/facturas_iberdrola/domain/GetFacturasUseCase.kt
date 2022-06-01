package com.example.facturas_iberdrola.domain

import com.example.facturas_iberdrola.Repository
import com.example.facturas_iberdrola.database.toDatabase
import javax.inject.Inject

class GetFacturasUseCase @Inject constructor(private val repository: Repository) {
    suspend operator fun invoke():List<Facturas2>{
        val facturas = repository.getAllFacturasFromApi()

        return if(facturas.isNotEmpty()){
            repository.clearFacturas()
            repository.insertFacturas(facturas.map { it.toDatabase() })
            facturas
        }else{
            repository.getAllFacturasFromDatabase()
        }
    }
}