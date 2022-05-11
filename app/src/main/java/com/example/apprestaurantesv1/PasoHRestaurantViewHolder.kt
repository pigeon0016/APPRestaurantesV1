package com.example.apprestaurantesv1

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.apprestaurantesv1.databinding.ItemRestaurantBinding
import com.squareup.picasso.Picasso

class PasoHRestaurantViewHolder (view: View, onItemListener: PasoGRestaurantAdapter.OnItemListener): RecyclerView.ViewHolder(view),View.OnClickListener{
    private val binding = ItemRestaurantBinding.bind(view)
    private val onItemListener = onItemListener
    private lateinit var restaurant : PasoFRestaurantes

    init{
        itemView.setOnClickListener(this)
    }
    override fun onClick(p0: View?) {
        onItemListener.clickRestaurant(restaurant)
    }

    fun bind(item: PasoFRestaurantes){
        with(binding){
            elpTvNombre.text = item.nombre
            elpTvFundacion.text = item.fundacion
            elpRbCalificacion.rating = item.calificacion!!.toFloat()
            Costo.text = item.costo
            Picasso.get().load(item.foto.toString()).into(ivItem)
        //Picasso.get().load(item.foto.first()).into(ivItem)
            //ivItem.setImageResource(R.drawable.)

            restaurant = item

        }
    }




  /*  init{
        item.setOnCLickListener(this)
    }*/




}

