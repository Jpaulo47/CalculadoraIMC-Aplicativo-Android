package com.example.calculadoraimc

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var botaoCalculaIMC: Button = findViewById(R.id.buttonCalcular)
        botaoCalculaIMC.setOnClickListener{calcularIMC()}
    }

    //pegar altura e peso do usuario
    private fun calcularIMC(){
        val inputAltura: EditText = findViewById(R.id.editTextAltura)
        val inputPeso: EditText = findViewById(R.id.editTextPeso)

        val altura = inputAltura.text.toString().toFloatOrNull()
        val peso = inputPeso.text.toString().toFloatOrNull()

        if (altura != null && peso != null){
            val imc = peso / (altura * altura)
            val mostraIMC: TextView = findViewById(R.id.textViewIMC)
            mostraIMC.text = " %.1f ".format(imc)

            val mostraResultado: ImageView = findViewById(R.id.imageViewIMC)

                when(imc){
                    in 0f..15.9999999f -> {
                        mostraResultado.setImageResource(R.drawable.magreza_grave)
                    }
                    in 16f..16.9999999f -> {
                        mostraResultado.setImageResource(R.drawable.magreza_moderada)
                    }
                    in 17f..18.4999999f -> {
                        mostraResultado.setImageResource(R.drawable.abaixo_do_peso)
                    }
                    in 18.5f..25.9999999f -> {
                        mostraResultado.setImageResource(R.drawable.saudavel)
                    }
                    in 25f..29.9999999f -> {
                        mostraResultado.setImageResource(R.drawable.sobrepeso)
                    }
                    in 30f..34.9999999f -> {
                        mostraResultado.setImageResource(R.drawable.obesidade_grau_i)
                    }
                    in 35f..39.9999999f -> {
                        mostraResultado.setImageResource(R.drawable.obesidade_grau_ii)
                    }
                    else -> {
                        mostraResultado.setImageResource(R.drawable.obesidade_grau_iii)
                    }

            }
        }
    }
}