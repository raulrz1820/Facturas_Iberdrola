package com.example.facturas_iberdrola.recyclerview

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.facturas_iberdrola.databinding.ItemFacturaBinding
import com.example.facturas_iberdrola.model.Facturas
import com.example.facturas_iberdrola.model.FacturasResponse

class FacturasViewHolder(view: View):RecyclerView.ViewHolder(view) {
    private val binding = ItemFacturaBinding.bind(view)

    fun bind(factura: Facturas){
        binding.tVfecha.text = factura.fecha
        binding.tVimporteOrdenacion.text = factura.importeOrdenacion.toString()
    }
}