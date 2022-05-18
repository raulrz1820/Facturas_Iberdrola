package com.example.facturas_iberdrola

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.facturas_iberdrola.databinding.ActivityMainBinding
import com.example.facturas_iberdrola.model.Facturas
import com.example.facturas_iberdrola.model.FacturasResponse
import com.example.facturas_iberdrola.network.FacturasApi
import com.example.facturas_iberdrola.recyclerview.FacturasAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    private lateinit var adapter:FacturasAdapter
    private val infoFacturas = mutableListOf<Facturas>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()

        val arrowIcon = findViewById<ImageView>(R.id.arrow_icon)
        val filterIcon = findViewById<ImageView>(R.id.filter_icon)
        val toolbarTitle = findViewById<TextView>(R.id.toolbar_title)



        filterIcon.setOnClickListener {
            startActivity(Intent(this@MainActivity, MainActivity2::class.java))
        }
    }
        private fun initRecyclerView(){
            binding.rvFacturas.layoutManager = LinearLayoutManager(this)
            adapter = FacturasAdapter(listOf())
            binding.rvFacturas.adapter = adapter
        }
        private fun getRetrofit(): Retrofit {
            return Retrofit.Builder()
                .baseUrl("https://viewnextandroid2.mocklab.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            //llamada a Retrofit
        }


         private fun getFacturas(query:String) {
            CoroutineScope(Dispatchers.IO).launch {
                val call: Response<FacturasResponse> = getRetrofit().create(FacturasApi::class.java).getFacturas()
                val facturita: FacturasResponse? = call.body()
                runOnUiThread {
                    //Si la llamada es exitosa se almacenan las facturas recibidas de la API en una variable local
                    if (call.isSuccessful) {
                        //si callBody es nullo facturas = lista vacía
                        val factures = facturita?.facturas ?: emptyList()

                        infoFacturas.clear()
                        infoFacturas.addAll(factures)
                        adapter.notifyDataSetChanged()


                        } else {
                            showError()
                        }
                    }


                }
            }

    private fun showError() {
        Toast.makeText(this, "Ha ocurrido un error", Toast.LENGTH_SHORT).show()
    }
}

