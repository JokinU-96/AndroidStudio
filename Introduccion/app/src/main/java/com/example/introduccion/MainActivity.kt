package com.example.introduccion

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.Checkable
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private val startActivityLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val data = result.data?.getStringExtra("datos") ?:"nulo"
        }
    }

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
            if (cervezaN != null){
                if (cervezaN > 0){
                    mayorDeEdad = true
                }
            }

            if (validar(mayorDeEdad)){
                var resultado = 0;
                var sb = StringBuilder()
                var c = 0;

                for (cantidad in cantidades){
                    if (cantidad != null){
                        resultado += cantidad
                        if(c != 0){
                            sb.append(" + ").append(cantidad)
                        }else{
                            sb.append(cantidad)
                        }
                        c += 1
                    }
                }
                sb.append(" = ").append(resultado)

                findViewById<TextView>(R.id.tvResultado).text = sb.toString();

                val intent:Intent = Intent(this, ej2::class.java)
                intent.putExtra("resultado", sb.toString())
                startActivity(intent)
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