package com.example.imccalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val peso = findViewById<EditText>(R.id.edtPeso)
        val altura = findViewById<EditText>(R.id.edtAltura)
        val btnCalcular = findViewById<Button>(R.id.btnCalcular)

        btnCalcular.setOnClickListener {

            val pesoTexto = peso.text.toString()
            val alturaTexto = altura.text.toString()

            if (pesoTexto.isEmpty() || alturaTexto.isEmpty()) {
                peso.error = "Digite o peso"
                altura.error = "Digite a altura"
            } else {

                val pesoValor = pesoTexto.toDouble()
                val alturaValor = alturaTexto.toDouble()

                if (pesoValor <= 0 || alturaValor <= 0) {
                    peso.error = "Digite um valor maior que 0"
                    altura.error = "Digite um valor maior que 0"
                } else {

                    val imc = pesoValor / (alturaValor * alturaValor)

                    val intent = Intent(this, ResultadoActivity::class.java)
                    intent.putExtra("IMC", imc)

                    startActivity(intent)
                }


            }
        }
    }
}