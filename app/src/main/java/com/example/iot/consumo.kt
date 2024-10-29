package com.example.iot

import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class consumo : AppCompatActivity() {
    private var consumoActual = 0.0f
    private var consumoTextView: TextView? = null
    private var costoTextView: TextView? = null
    private var horasUsoTextView: TextView? = null
    private var progressBar: ProgressBar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.consumo)

        consumoTextView = findViewById(R.id.consumo_actual)
        costoTextView = findViewById(R.id.costo_aproximado)
        horasUsoTextView = findViewById(R.id.horas_uso)
        progressBar = findViewById(R.id.progressBar)

        val btnConsumo = findViewById<Button>(R.id.btnConsumo)
        btnConsumo.setOnClickListener {
            mostrarConsumo()
        }

        val btnHome = findViewById<Button>(R.id.btnHome)
        btnHome.setOnClickListener {
            finish()
        }
    }

    private fun mostrarConsumo() {
        consumoActual = (Math.random() * 10 + 1).toFloat()
        consumoTextView!!.text = "Consumo Actual: " + String.format("%.2f", consumoActual) + " kWh"

        val costoAproximado = calcularCosto(consumoActual)
        costoTextView!!.text = "Costo Aproximado: $" + String.format("%.2f", costoAproximado)

        val progreso = (consumoActual / 10 * 100).toInt()
        progressBar!!.progress = progreso

        mostrarMensajeConsumo(progreso)

        calcularHorasUso()
    }

    private fun calcularCosto(consumo: Float): Float {
        val tarifaPorKWh = 150.0f
        return consumo * tarifaPorKWh
    }

    private fun calcularHorasUso() {
        horasUsoTextView!!.text = "Horas de uso: " + String.format("%.2f", consumoActual)
    }

    private fun mostrarMensajeConsumo(progreso: Int) {
        when {
            progreso > 80 -> {
                Toast.makeText(this, "Consumo Alto", Toast.LENGTH_SHORT).show()
            }
            progreso > 50 -> {
                Toast.makeText(this, "Consumo Moderado", Toast.LENGTH_SHORT).show()
            }
            else -> {
                Toast.makeText(this, "Consumo Bajo", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
