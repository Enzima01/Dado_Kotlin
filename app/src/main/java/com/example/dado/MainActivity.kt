package com.example.dado

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
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

        val dado = findViewById<ImageView>(R.id.imageView)
        val botaoJogar = findViewById<ImageView>(R.id.imageView2)
        val textoResultado = findViewById<TextView>(R.id.textResult)

        dado.setImageResource(R.drawable.dadologo)

        botaoJogar.setOnClickListener {
            val numero = (1..6).random()

            textoResultado.visibility = TextView.VISIBLE
            textoResultado.text = "Número sorteado: $numero"

            val imagem = when (numero) {
                1 -> R.drawable.face1
                2 -> R.drawable.face2
                3 -> R.drawable.face3
                4 -> R.drawable.face4
                5 -> R.drawable.face5
                else -> R.drawable.face6
            }
            dado.setImageResource(imagem)
        }
    }
}
