package com.example.calculatorbasicapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.EditText
import android.widget.TextView
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Referencias a los EditText y TextView
        val etA = findViewById<EditText>(R.id.etValorA)
        val etB = findViewById<EditText>(R.id.etValorB)
        val etC = findViewById<EditText>(R.id.etValorC)
        val resultado = findViewById<TextView>(R.id.tvResultado)

        // Botones
        val btnSumar = findViewById<Button>(R.id.btnSumar)
        val btnRestar = findViewById<Button>(R.id.btnRestar)
        val btnMultiplicar = findViewById<Button>(R.id.btnMultiplicar)
        val btnDividir = findViewById<Button>(R.id.btnDividir)

        // Botón SUMAR
        btnSumar.setOnClickListener {
            val valores = obtenerValores(etA, etB, etC)
            valores?.let {
                val res = it[0] + it[1] + it[2]
                resultado.text = "Resultado:\nA + B + C = $res"
            }
        }

        // Botón RESTAR
        btnRestar.setOnClickListener {
            val valores = obtenerValores(etA, etB, etC)
            valores?.let {
                val res = it[0] - it[1] - it[2]
                resultado.text = "Resultado:\nA - B - C = $res"
            }
        }

        // Botón MULTIPLICAR
        btnMultiplicar.setOnClickListener {
            val valores = obtenerValores(etA, etB, etC)
            valores?.let {
                val res = it[0] * it[1] * it[2]
                resultado.text = "Resultado:\nA × B × C = $res"
            }
        }

        // Botón DIVIDIR
        btnDividir.setOnClickListener {
            val valores = obtenerValores(etA, etB, etC)
            valores?.let {
                if (it[1] == 0.0 || it[2] == 0.0) {
                    Toast.makeText(this, "No se puede dividir entre cero", Toast.LENGTH_SHORT).show()
                } else {
                    val res = it[0] / it[1] / it[2]
                    resultado.text = "Resultado:\nA ÷ B ÷ C = $res"
                }
            }
        }

    }

    // Función para convertir los inputs en números
    private fun obtenerValores(et1: EditText, et2: EditText, et3: EditText): List<Double>? {
        return try {
            listOf(
                et1.text.toString().toDouble(),
                et2.text.toString().toDouble(),
                et3.text.toString().toDouble()
            )
        } catch (e: NumberFormatException) {
            Toast.makeText(this, "Por favor ingrese solo números válidos", Toast.LENGTH_SHORT).show()
            null
        }
    }
}