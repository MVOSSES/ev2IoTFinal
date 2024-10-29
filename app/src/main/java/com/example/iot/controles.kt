package com.example.iot

import android.content.Intent
import android.media.Image
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.math.log

class Controles : AppCompatActivity() {

    //Definir valor por defecto del btn de luz y cerraduras
    var luzXdefecto= 0
    var cerraduraXdefecto = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.controles)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.controlRemoto)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }



        //obtener el boton de luces
        val luzOnOff = findViewById<Button>(R.id.btnLuces)
        //Listener para el btn
        luzOnOff.setOnClickListener {
            fnOnOff()
        }

        //obtener el btn de cerradura
        val cerraduraLU = findViewById<Button>(R.id.btnCandado)
        //listener
        cerraduraLU.setOnClickListener {
            fnLockUnlock()
        }

        //btn volver al dashboard
        //Btn ir a pantalla control remoto
        val irPP: Button = findViewById(R.id.CRvolver)
        irPP.setOnClickListener {
            //cariable para llamar pantalla domotica
            val intent = Intent(this, Dashboard::class.java)
            startActivity(intent)
        }

    }



    private fun fnOnOff() {

        try {
            //Toast.makeText(this,"Valor: $luzXdefecto",Toast.LENGTH_SHORT).show()
            val lgtState: ImageView= findViewById(R.id.imgLuz)
            val lgtMsg: Button= findViewById(R.id.btnLuces)

            when(luzXdefecto){
                0->{
                    lgtState.setImageResource(R.drawable.lighton)
                    lgtMsg.text = "On"
                }
                1->{
                    lgtState.setImageResource(R.drawable.lightoff)
                    lgtMsg.text = "Off"
                }
            }
            if (luzXdefecto==0){
                luzXdefecto=1
            }else{
                luzXdefecto=0
            }
        }catch (e:Exception){
            Log.e("Error", e.message.toString())
        }
    }

    private fun fnLockUnlock() {
        try {
            val lockState: ImageView= findViewById(R.id.imgCandado)
            val lockMsg: Button= findViewById(R.id.btnCandado)

            when(cerraduraXdefecto){
                0->{
                    lockState.setImageResource(R.drawable.lock)
                    lockMsg.text = "Locked"
                }
                1->{
                    lockState.setImageResource(R.drawable.unlock)
                    lockMsg.text = "Unlocked"
                }
            }
            if (cerraduraXdefecto == 0){
                cerraduraXdefecto = 1
            }else{
                cerraduraXdefecto = 0
            }
        }catch (e:Exception){
            Log.e("Error", e.message.toString())
        }
    }

}