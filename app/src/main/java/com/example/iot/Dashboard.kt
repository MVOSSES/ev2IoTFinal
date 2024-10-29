package com.example.iot

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Dashboard : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.dashboard)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.dashboard)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val dashBoton1 = findViewById<Button>(R.id.dashboton1)
        dashBoton1.setOnClickListener {
            val intent = Intent(this, consumo::class.java)
            startActivity(intent)
        }

        val dashBoton2 = findViewById<Button>(R.id.dashboton2)
        dashBoton2.setOnClickListener {
            val intent = Intent(this, Controles::class.java)
            startActivity(intent)
        }

        val atrasInicio: Button = findViewById(R.id.atrasboton)
        atrasInicio.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }



}
