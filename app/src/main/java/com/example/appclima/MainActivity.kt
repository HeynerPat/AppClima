    package com.example.appclima

    import android.os.Bundle
    import android.util.Log
    import android.widget.TextView
    import androidx.appcompat.app.AppCompatActivity
    import com.android.volley.Request
    import com.android.volley.Response
    import com.android.volley.toolbox.StringRequest
    import com.android.volley.toolbox.Volley
    import com.google.gson.Gson


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

        if(Network.hayRed(this)){
            //Toast.makeText(this,"Si hay Red", Toast.LENGTH_LONG).show()
            solicitudHTTPVolley("http://api.openweathermap.org/data/2.5/weather?id=3527639&appid=494454b4c5cc62db452b966478410685")
            //494454b4c5cc62db452b966478410685
            //FCP 3527639

        }else{
            //Toast.makeText(this,"No hay una conexión a internet", Toast.LENGTH_LONG).show()
        }
        /*
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
         */
    }

        //Metodo para Volley
        private fun solicitudHTTPVolley(url:String){
            val queue = Volley.newRequestQueue(this)

            val solicitud = StringRequest(Request.Method.GET, url , Response.Listener<String>{
                    response ->
                try {
                    Log.d( "solicitudHTTPVolley", response)

                    val gson = Gson()
                    val ciudad = gson.fromJson(response, Ciudad::class.java)
                    tvCiudad?.text = ciudad.name
                    tvGrados?.text = ciudad.main?.temp.toString()+"°"
                    tvEstatus?.text = ciudad.weather?.get(0)?.description
                }catch (e: Exception){
                } }, Response.ErrorListener{} )
            queue.add(solicitud)
        }
}