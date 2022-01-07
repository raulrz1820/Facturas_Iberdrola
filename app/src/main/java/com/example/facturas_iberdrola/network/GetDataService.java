package com.example.facturas_iberdrola.network;

import com.example.facturas_iberdrola.Model.Facturas;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetDataService {

    @GET("/facturas")
    Call<List<Facturas>> getAllFacturas();
}
