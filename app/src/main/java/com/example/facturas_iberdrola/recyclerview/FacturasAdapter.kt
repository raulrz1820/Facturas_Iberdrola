package com.example.facturas_iberdrola.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.facturas_iberdrola.R
import com.example.facturas_iberdrola.model.Facturas
import com.example.facturas_iberdrola.model.FacturasResponse

class FacturasAdapter(private val itemFacturas:List<Facturas>): RecyclerView.Adapter<FacturasViewHolder>() {

    var listFacturas : List<Facturas> = itemFacturas

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FacturasViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return FacturasViewHolder(layoutInflater.inflate(R.layout.item_factura, parent, false))
    }

    fun addAll(lista : List<Facturas>) {
        listFacturas =  lista
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: FacturasViewHolder, position: Int) {
        val item = itemFacturas[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return itemFacturas.size
    }
}