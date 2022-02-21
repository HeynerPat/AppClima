    package com.example.appclima

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast

    class MainActivity : AppCompatActivity() {

    var tvCiudad:TextView?=null
    var tvGrados:TextView?=null
    var tvEstatus:TextView?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvCiudad = findViewById(R.id.tvCiudad)
        tvGrados = findViewById(R.id.tvGrados)
        tvEstatus = findViewById(R.id.tvEstatus)

        val ciudad = intent.getStringExtra("com.example.appclima.ciudades.CIUDAD")

        val ciudadFCP = Ciudad(nombre= "Felipe Carrillo Puerto", grados= 15, estatus="Soleado")
        val ciudadBerlin = Ciudad(nombre= "Berlin", grados= 30, estatus="Cielo Despejado")

        if(ciudad == "Ciudad-FCP"){
            //Mostrar informacion de FCP
            tvCiudad?.text = ciudadFCP.nombre
            tvGrados?.text = ciudadFCP.grados.toString()+"°"
            tvEstatus?.text = ciudadFCP.estatus

        }else if(ciudad == "Ciudad-Berlin"){
            //Mostrar Informacion de Berlin
            tvCiudad?.text = ciudadBerlin.nombre
            tvGrados?.text = ciudadBerlin.grados.toString()+"°"
            tvEstatus?.text = ciudadBerlin.estatus
        }else{
            Toast.makeText(this, "No se encuentra La Informacion", Toast.LENGTH_SHORT).show()
        }
    }
}