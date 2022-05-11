package com.example.apprestaurantesv1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.apprestaurantesv1.databinding.FragmentPasoBPrincipalBinding
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// FRAGMENT que contiene la paguna prncialp el home de la app
class PasoBPrincipal : Fragment(), PasoGRestaurantAdapter.OnItemListener {
     private lateinit var  binding: FragmentPasoBPrincipalBinding
     lateinit var autenticacion: FirebaseAuth
     lateinit var loginFragment: PasoALogin

    //++++++++++++++++++++++++++++++++++++++Retrofit
    private lateinit var adapter : PasoGRestaurantAdapter
    private var variableres = arrayListOf<PasoFRestaurantes>()
    //private val restauranteimagenes: ArrayList<PasoFRestaurantes>()
    //++++++++++++++++++++++++++++++++++++++Retrofit



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPasoBPrincipalBinding.inflate(inflater, container,false)
        autenticacion = FirebaseAuth.getInstance()
        loginFragment = PasoALogin()
        return binding.root

        //++++++++++++++++++++++++++++++++++++++Retrofit
        getAllRestaurants()
        initRecyclerView()
        //++++++++++++++++++++++++++++++++++++++Retrofit
    }


    private fun initRecyclerView() {
        adapter = PasoGRestaurantAdapter(variableres,this)

        binding.rvRestaurants.layoutManager = LinearLayoutManager(context)
        binding.rvRestaurants.adapter = adapter

        //findViewById<RecyclerView>(R.id.rvRestaurants).layoutManager = LinearLayoutManager(this)
        //findViewById<RecyclerView>(R.id.rvRestaurants).addItemDecoration(DividerItemDecoration(applicationContext,1))
        // findViewById<RecyclerView>(R.id.rvRestaurants).adapter = adapter
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
         binding.btnLogOut.setOnClickListener{
             autenticacion.signOut()
             activity?.supportFragmentManager?.beginTransaction()
                 ?.replace(R.id.fragmentContainerView,loginFragment)
                 ?.commit()
         }
    }

    //********************************************* Parte de los restaurantes
    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://demo5556878.mockable.io/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }





    private fun getAllRestaurants() {
        CoroutineScope(Dispatchers.IO).launch {
            val call: Response<PasoERestaurantResponse> = getRetrofit().create(PasoDAPIServices::class.java).getAllRestaurants("allrestarants")
            val allRestaurants:PasoERestaurantResponse? = call.body()
            requireActivity().runOnUiThread {
                if(call.isSuccessful){
                    var restaurants: ArrayList<PasoFRestaurantes> = (allRestaurants?.restaurantes ?: emptyArray<PasoERestaurantResponse>()) as ArrayList<PasoFRestaurantes>
                    variableres.clear()
                    variableres.addAll(restaurants)
                    adapter.notifyDataSetChanged()
                }
            }
        }
    }

    override fun clickRestaurant(resta: PasoFRestaurantes) {

    }






}