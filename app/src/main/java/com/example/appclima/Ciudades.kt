package com.example.appclima

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class Ciudades : AppCompatActivity() {
    val TAG = "com.example.appclima.ciudades.CIUDAD"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ciudades)
        val bFCP = findViewById<Button>(R.id.bFCP)
        val bBerlin = findViewById<Button>(R.id.bBerlin)

        bFCP.setOnClickListener(View.OnClickListener{
            val intent = Intent(this,MainActivity::class.java)
            intent.putExtra(TAG, "3527639")
            startActivity(intent)
        })

        bBerlin.setOnClickListener(View.OnClickListener{
            val intent = Intent(this,MainActivity::class.java)
            intent.putExtra(TAG, "2950159")
            startActivity(intent)
        })
    }
}