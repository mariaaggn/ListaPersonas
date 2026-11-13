package com.example.listapersonas

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.listapersonas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Evita que la lista quede debajo de la barra de estado
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        initRecyclerView()
    }

    private fun initRecyclerView() {
        binding.rvPersonas.layoutManager = LinearLayoutManager(this)
        binding.rvPersonas.adapter = PersonaAdapter(PersonaProvider.cargarPersonas()) { persona ->
            onItemSelected(persona)
        }
    }

    private fun onItemSelected(persona: Persona) {
        Toast.makeText(this, "Has pulsado sobre ${persona.nombre}", Toast.LENGTH_SHORT).show()
    }
}