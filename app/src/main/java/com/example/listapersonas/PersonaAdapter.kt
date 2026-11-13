package com.example.listapersonas

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class PersonaAdapter(
    private val personas: List<Persona>,
    private val onClickListener: (Persona) -> Unit
) : RecyclerView.Adapter<PersonaViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonaViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_persona, parent, false)
        return PersonaViewHolder(view)
    }

    override fun onBindViewHolder(holder: PersonaViewHolder, position: Int) {
        holder.render(personas[position], onClickListener)
    }

    override fun getItemCount(): Int = personas.size
}