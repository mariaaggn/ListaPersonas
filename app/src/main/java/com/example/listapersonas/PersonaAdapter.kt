package com.example.listapersonas

    import android.view.LayoutInflater
    import android.view.ViewGroup
    import android.widget.ImageView
    import android.widget.TextView
    import androidx.recyclerview.widget.RecyclerView

    class PersonaAdapter(private val lista: List<Persona>) :
        RecyclerView.Adapter<PersonaAdapter.PersonaViewHolder>() {

        class PersonaViewHolder(view: android.view.View) : RecyclerView.ViewHolder(view) {
            val imgFoto: ImageView = view.findViewById(R.id.imgFoto)
            val txtNombre: TextView = view.findViewById(R.id.txtNombre)
            val txtDescripcion: TextView = view.findViewById(R.id.txtDescripcion)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonaViewHolder {
            val vista = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_persona, parent, false)
            return PersonaViewHolder(vista)
        }

        override fun onBindViewHolder(holder: PersonaViewHolder, position: Int) {
            val persona = lista[position]
            holder.imgFoto.setImageResource(persona.foto)
            holder.txtNombre.text = persona.nombre
            holder.txtDescripcion.text = persona.descripcion
        }

        override fun getItemCount(): Int = lista.size
    }
