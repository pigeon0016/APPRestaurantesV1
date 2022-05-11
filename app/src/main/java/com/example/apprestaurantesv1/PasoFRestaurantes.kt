package com.example.apprestaurantesv1

import com.google.gson.annotations.SerializedName

data class PasoFRestaurantes(
    @SerializedName("id") var id: String? = null,
    @SerializedName("Imagen") var foto : String? = null,
@SerializedName("Nombre_rest") var nombre: String? = null,
@SerializedName("Calificacion") var calificacion: String? = null,
@SerializedName("Fundacion")var fundacion: String? = null,
@SerializedName("Costo_Av") var costo: String? = null,
@SerializedName("reseñas") var resena : String? = null,
@SerializedName("galeria") var galeria: ArrayList<String>? = null
)
