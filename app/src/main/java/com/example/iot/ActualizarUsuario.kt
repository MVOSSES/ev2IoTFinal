package com.example.iot

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ActualizarUsuario : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.actualizarusuario)

        val inputUsuarioAnterior = findViewById<EditText>(R.id.inputUsuarioAnterior)
        val inputNuevoUsuario = findViewById<EditText>(R.id.inputNuevoUsuario)
        val btnActualizarUsuario = findViewById<Button>(R.id.btnActualizarUsuario)

        btnActualizarUsuario.setOnClickListener {
            try {

                val usuarioAnterior = inputUsuarioAnterior.text.toString()
                val nuevoUsuario = inputNuevoUsuario.text.toString()

                val sharedPreferences = getSharedPreferences("guardado", Context.MODE_PRIVATE)
                val usuarioGuardado = sharedPreferences.getString("usuario", "")

                if (usuarioAnterior == usuarioGuardado) {
                    val editor = sharedPreferences.edit()
                    editor.putString("usuario", nuevoUsuario)
                    editor.apply()
                    Toast.makeText(this, "Usuario actualizado con éxito", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Usuario anterior incorrecto", Toast.LENGTH_SHORT).show()
                }}catch (e:Exception){
                Log.e("Error", e.message.toString())}
        }

        // Lógica para el botón de Volver al volver al menú anterior
        //La función real de este botón es volver al menú anterior, no volver al login
        //no cambio el nombre de la función solo para no tener que reescribir tod0 de nuevo
        val btnVolverLogin: Button = findViewById(R.id.btnVolverLogin)
        btnVolverLogin.setOnClickListener {
            val intent = Intent(this, OpcionesCuenta::class.java)
            startActivity(intent)
        }
    }
}
