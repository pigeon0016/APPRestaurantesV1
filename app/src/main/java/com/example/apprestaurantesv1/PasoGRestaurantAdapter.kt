package com.example.apprestaurantesv1
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class PasoGRestaurantAdapter(private val restautantes:ArrayList<PasoFRestaurantes>, val onItemListener: OnItemListener): RecyclerView.Adapter<PasoHRestaurantViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PasoHRestaurantViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return PasoHRestaurantViewHolder(layoutInflater.inflate(R.layout.item_restaurant,parent,false),onItemListener)
    }

    override fun onBindViewHolder(holder: PasoHRestaurantViewHolder, position: Int) {
        val item = restautantes[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return restautantes.size
    }

    interface OnItemListener {
        fun clickRestaurant(resta: PasoFRestaurantes)
    }
}