package com.example.facturas_iberdrola.Model;

import java.util.Date;

public class Facturas {

    private Integer numFacturas;
    private String facturas;
    private String descEstado;
    private Integer importeOrdenacion;
    private Date fecha;

    public Facturas(String descEstado) {
        this.descEstado = descEstado;
    }

    public Facturas(Integer importeOrdenacion) {
        this.importeOrdenacion = importeOrdenacion;
    }

    public Integer getNumFacturas() {
        return numFacturas;
    }

    public void setNumFacturas(Integer numFacturas) {
        this.numFacturas = numFacturas;
    }

    public String getFacturas() {
        return facturas;
    }

    public void setFacturas(String facturas) {
        this.facturas = facturas;
    }

    public String getDescEstado() {
        return descEstado;
    }

    public void setDescEstado(String descEstado) {
        this.descEstado = descEstado;
    }

    public Integer getImporteOrdenacion() {
        return importeOrdenacion;
    }

    public void setImporteOrdenacion(Integer importeOrdenacion) {
        this.importeOrdenacion = importeOrdenacion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Facturas(Date fecha) {
        this.fecha = fecha;
    }
}
