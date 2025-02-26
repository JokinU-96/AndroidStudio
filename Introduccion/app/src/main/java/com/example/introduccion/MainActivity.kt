package com.example.introduccion

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.Checkable
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
            var mayorDeEdad = false

            val cocacola = findViewById<EditText>(R.id.edCocacola).text;
            val kaslimon = findViewById<EditText>(R.id.edKasLimon).text;
            val kasnaranja = findViewById<EditText>(R.id.edKasNaranja).text;
            val redbull = findViewById<EditText>(R.id.edRedBull).text;
            val cerveza = findViewById<EditText>(R.id.edCerveza).text;
            val vino = findViewById<EditText>(R.id.edVino).text;

            val cocacolaN: Int? = cocacola.toString().toIntOrNull()
            val kaslimonN: Int? = kaslimon.toString().toIntOrNull()
            val kasnaranjaN: Int? = kasnaranja.toString().toIntOrNull()
            val redbullN: Int? = redbull.toString().toIntOrNull()
            val cervezaN: Int? = cerveza.toString().toIntOrNull()
            val vinoN: Int? = vino.toString().toIntOrNull()

            val cantidades = listOf(cocacolaN, kaslimonN, kasnaranjaN, redbullN, cervezaN, vinoN)

            if (vinoN != null){
                if (vinoN > 0){
                    mayorDeEdad = true
                }
            }
            if (cervezaN != null){3
                if (cervezaN > 0){
                    mayorDeEdad = true
                }
            }

            if (validar(mayorDeEdad)){
                var resultado = 0;

                for (cantidad in cantidades){
                    if (cantidad != null){
                        resultado += cantidad
                    }
                }

                findViewById<TextView>(R.id.tvResultado).text = resultado.toString();

                /*if (cocacolaN != null && kaslimonN != null && kasnaranjaN != null && redbullN != null && cervezaN != null && vinoN != null){
                    resultado = cocacolaN + kaslimonN + kasnaranjaN + redbullN + cervezaN + vinoN;
                    findViewById<TextView>(R.id.tvResultado).setText(resultado);
                }else{
                    findViewById<TextView>(R.id.tvResultado).setText("No se pudo calcular el resultado por insertar valores nulos o erroneos.")
                }*/
            }
        }
    }
    fun validar(esMayorDeEdad: Boolean): Boolean{
        if(findViewById<EditText>(R.id.etNombre).text.isEmpty()){
            findViewById<TextView>(R.id.tvResultado).setText("Tienes que insertar tu nombre y apellido.")
            return false
        }
        if(!findViewById<CheckBox>(R.id.sEdad).isChecked && esMayorDeEdad){
            findViewById<TextView>(R.id.tvResultado).setText("Tienes que ser mayor de edad para comprar alcohol.")
            return false
        }
        return true
    }

}