package com.example.apprestaurantesv1

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface PasoDAPIServices {
    @GET
    suspend fun getAllRestaurants(@Url url: String): Response<PasoERestaurantResponse>
}