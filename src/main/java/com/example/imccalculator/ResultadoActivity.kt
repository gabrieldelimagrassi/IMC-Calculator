package com.example.imccalculator

import android.os.Bundle
import android.view.MenuItem
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.appbar.MaterialToolbar

class ResultadoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_resultado)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val toolbar = findViewById<MaterialToolbar>(R.id.matToolbarResultado)
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        val resultadoIMC = findViewById<TextView>(R.id.tvResultado)
        val classificacaoIMC = findViewById<TextView>(R.id.tvResultadoClassificacao)

        val imc = intent.getDoubleExtra("IMC", 0.0)

        var classificacao = " "

        if (imc < 18.5) {
            classificacao = "ABAIXO DO PESO"
        } else if (imc < 25) {
            classificacao = "NORMAL"
        } else if (imc < 30) {
            classificacao = "SOBREPESO"
        } else if (imc < 35) {
            classificacao = "OBESIDADE GRAU I"
        } else if (imc < 40) {
            classificacao = "OBESIDADE GRAU II"
        } else {
            classificacao = "OBESIDADE GRAU III"
        }

        resultadoIMC.text = "%.2f".format(imc)
        classificacaoIMC.text = classificacao
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
}