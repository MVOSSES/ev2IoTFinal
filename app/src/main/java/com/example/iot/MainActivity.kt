package com.example.iot

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.inicio)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val irDashboard: Button = findViewById(R.id.botoniniciar)
        irDashboard.setOnClickListener {
            try {

                val usuario: String = findViewById<EditText>(R.id.input_usuario).text.toString()
                val contrasena: String =
                    findViewById<EditText>(R.id.input_contrasena).text.toString()

                if (usuario.isNotEmpty() && contrasena.isNotEmpty()) {
                    val compartirprefe = getSharedPreferences("guardado", Context.MODE_PRIVATE)
                    val guardarusuario = compartirprefe.getString("usuario", null)
                    val guardarcontra = compartirprefe.getString("contrasena", null)

                    if (usuario == guardarusuario && contrasena == guardarcontra) {
                        val intent = Intent(this, Dashboard::class.java)
                        startActivity(intent)
                    } else {
                        Toast.makeText(this, "Datos incorrectos", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    if (usuario.isEmpty()) {
                        Toast.makeText(this, "No has ingresado un usuario", Toast.LENGTH_SHORT)
                            .show()
                    }
                    if (contrasena.isEmpty()) {
                        Toast.makeText(this, "No has ingresado una contraseña", Toast.LENGTH_SHORT)
                            .show()
                    }
                }
            }catch (e:Exception){
                Log.e("Error", e.message.toString())}
        }

        val irRegistro: Button = findViewById(R.id.botonregistro)
        irRegistro.setOnClickListener {
            val intent = Intent(this, Registrar::class.java)
            startActivity(intent)
        }

        val irOpciones: Button = findViewById(R.id.btnOpcionesCuenta)
        irOpciones.setOnClickListener {
            val intent = Intent(this, OpcionesCuenta::class.java)
            startActivity(intent)
        }
    }
}
