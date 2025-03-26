package com.example.ej4

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import com.example.ej4.databinding.ActivityMainBinding
import com.example.ej4.modelo.Usuario
import com.example.ej4.modelo.Vehiculo

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    var usuario: Usuario? = null
    var vehiculos: MutableList<Vehiculo> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        insertarVehiculos()

        setSupportActionBar(binding.toolbar)

        val navController = findNavController(R.id.nav_host_fragment_content_main)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)
    }

    fun insertarVehiculos(){
        vehiculos.add(Vehiculo("moto", "Dukati", 1250.00))
        vehiculos.add(Vehiculo("moto", "Kawasaki", 890.00))
        vehiculos.add(Vehiculo("moto", "BMW", 980.00))
        vehiculos.add(Vehiculo("coche", "Nissan", 2500.00))
        vehiculos.add(Vehiculo("coche", "Renault", 9800.00))
        vehiculos.add(Vehiculo("coche", "Peugeot", 15000.00))
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_volver -> {
                findNavController(R.id.nav_host_fragment_content_main).popBackStack()
                true
            }
            else -> false
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}