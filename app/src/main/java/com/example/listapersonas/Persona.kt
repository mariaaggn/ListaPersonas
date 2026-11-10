package com.example.listapersonas

data class Persona(
    val nombre: String,
    val descripcion: String,
    val foto: Int,
    val anioNacimiento: Int,
    val email: String,
    val telefono: String,
    val ciudad: String
)