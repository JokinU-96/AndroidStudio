package com.example.introduccion

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
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

        findViewById<Button>(R.id.bCalcular).setOnClickListener{
            if (validar()){
                val cocaCola = findViewById<EditText>(R.id.edCocacola).text
                findViewById<TextView>(R.id.tvResultado).setText(cocaCola)
            }
        }
    }
    fun validar(): Boolean{
        if(findViewById<EditText>(R.id.etNombre).text.isEmpty()){
            findViewById<TextView>(R.id.tvResultado).setText("Tienes que insertar tu nombre y apellido.")
            return false
        }
        return true
    }

}