package com.example.iot

import android.content.Intent
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Registrar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.registro)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.registro)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val irAInicio: Button = findViewById(R.id.botonderegistro)
        irAInicio.setOnClickListener {
            try {
                val nombre: String = findViewById<EditText>(R.id.input_name).text.toString()
                val contrasena: String = findViewById<EditText>(R.id.input_password).text.toString()

                if (nombre.isNotEmpty() && contrasena.isNotEmpty()) {
                    val compartirprefe = getSharedPreferences("guardado", Context.MODE_PRIVATE)
                    val editor = compartirprefe.edit()
                    editor.putString("usuario", nombre)
                    editor.putString("contrasena", contrasena)
                    editor.apply()

                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                } else {
                    if (nombre.isEmpty()) {
                        Toast.makeText(this, "No has ingresado un nombre", Toast.LENGTH_SHORT).show()
                    }
                    if (contrasena.isEmpty()) {
                        Toast.makeText(this, "No has ingresado una contraseña", Toast.LENGTH_SHORT).show()
                    }
                }

            } catch (e: Exception) {
                Log.e("Error", e.message.toString())
            }
        }


    }

}