package com.example.apprestaurantesv1

import com.google.gson.annotations.SerializedName

data class PasoERestaurantResponse(
    @SerializedName("restaurantes") var restaurantes : ArrayList<PasoFRestaurantes> = arrayListOf()
)
