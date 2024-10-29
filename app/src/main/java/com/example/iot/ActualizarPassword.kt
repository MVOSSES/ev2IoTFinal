package com.example.iot

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ActualizarPassword : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.actualizarpassword)

        val inputUsuario = findViewById<EditText>(R.id.inputUsuarioPassword)
        val inputPasswordAnterior = findViewById<EditText>(R.id.inputPasswordAnterior)
        val inputNuevaPassword = findViewById<EditText>(R.id.inputNuevaPassword)
        val btnActualizarPassword = findViewById<Button>(R.id.btnActualizarPassword)

        //La función real de este botón es volver al menú anterior, no volver al login
        //no cambio el nombre de la función solo para no tener que reescribir tod0 de nuevo
        val btnVolverLogin = findViewById<Button>(R.id.btnVolverLoginPassword) //función para el btn regresar al menu anterior

        btnActualizarPassword.setOnClickListener {
            try{
            val usuario = inputUsuario.text.toString()
                val passwordAnterior = inputPasswordAnterior.text.toString()
                val nuevaPassword = inputNuevaPassword.text.toString()

                val sharedPreferences = getSharedPreferences("guardado", Context.MODE_PRIVATE)
                val usuarioGuardado = sharedPreferences.getString("usuario", "")
                val contrasenaGuardada = sharedPreferences.getString("contrasena", "")

                if (usuario == usuarioGuardado && passwordAnterior == contrasenaGuardada) {
                    val editor = sharedPreferences.edit()
                    editor.putString("contrasena", nuevaPassword)
                    editor.apply()
                    Toast.makeText(this, "Contraseña actualizada con éxito", Toast.LENGTH_SHORT).show()

                    finish()
                } else {
                    Toast.makeText(this, "Usuario o contraseña anterior incorrectos", Toast.LENGTH_SHORT).show()
                }}catch (e:Exception){
                Log.e("Error", e.message.toString())
                }
        }

        // Lógica para el botón "Volver al Login"
        //btn erroneo debe conducir al menu de gestion de usuarios
//        btnVolverLogin.setOnClickListener {
//            val intent = Intent(this, MainActivity::class.java)
//            startActivity(intent)
//            finish() // Cierra la actividad actual
//       }


        //btn para volver al menú anterior
        btnVolverLogin.setOnClickListener {
            val intent = Intent(this, OpcionesCuenta::class.java)
            startActivity(intent)
        }
    }
}
