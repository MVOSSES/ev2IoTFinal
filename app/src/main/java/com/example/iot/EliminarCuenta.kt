package com.example.iot

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class EliminarCuenta : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.eliminarcuenta)

        val inputUsuarioEliminar = findViewById<EditText>(R.id.inputUsuarioEliminar)
        val inputPasswordEliminar = findViewById<EditText>(R.id.inputPasswordEliminar)
        val btnConfirmarEliminarCuenta = findViewById<Button>(R.id.btnConfirmarEliminarCuenta)

        //La función real de este botón es volver al menú anterior, no volver al login
        //no cambio el nombre de la función solo para no tener que reescribir tod0 de nuevo
        val btnVolverLoginEliminar = findViewById<Button>(R.id.btnVolverLoginEliminar)

        // Lógica para eliminar cuenta
        btnConfirmarEliminarCuenta.setOnClickListener {
            try {

                val usuarioEliminar = inputUsuarioEliminar.text.toString()
                val passwordEliminar = inputPasswordEliminar.text.toString()

                val sharedPreferences = getSharedPreferences("guardado", Context.MODE_PRIVATE)
                val usuarioGuardado = sharedPreferences.getString("usuario", "")
                val contrasenaGuardada = sharedPreferences.getString("contrasena", "")

                if (usuarioEliminar == usuarioGuardado && passwordEliminar == contrasenaGuardada) {
                    // Eliminar los datos de la cuenta
                    val editor = sharedPreferences.edit()
                    editor.clear() // Elimina todas las preferencias
                    editor.apply()

                    Toast.makeText(this, "Cuenta eliminada con éxito", Toast.LENGTH_SHORT).show()
                    // Regresar a la pantalla de inicio de sesión
                    finish() // Cierra la actividad actual
                } else {
                    Toast.makeText(this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show()
                }}catch (e:Exception){
                Log.e("Error", e.message.toString())}
        }

        // volver al menú anterior
        btnVolverLoginEliminar.setOnClickListener {
            val intent = Intent(this, OpcionesCuenta::class.java)
            startActivity(intent)
        }
    }
}
