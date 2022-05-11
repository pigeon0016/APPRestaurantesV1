package com.example.apprestaurantesv1

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.apprestaurantesv1.databinding.ActivityMainBinding
import com.example.apprestaurantesv1.databinding.FragmentPasoBPrincipalBinding
import com.example.apprestaurantesv1.databinding.FragmentPasoCRegisterBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.security.Principal


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
   // private lateinit var binding: FragmentPasoBPrincipalBinding
    private lateinit var loginFragment: PasoALogin
    private lateinit var principalFragment: PasoBPrincipal
    private lateinit var registerFragment: PasoCRegister
    //Variable para autenticar
    lateinit var autenticacion: FirebaseAuth

    //++++++++++++++++++++++++++++++++++++++Retrofit
    /*private lateinit var adapter : PasoGRestaurantAdapter
    private var variableres = arrayListOf<PasoFRestaurantes>()*/
    //private val restauranteimagenes: ArrayList<PasoFRestaurantes>()
    //++++++++++++++++++++++++++++++++++++++Retrofit

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        autenticacion= FirebaseAuth.getInstance()
        loginFragment = PasoALogin()
        principalFragment = PasoBPrincipal()
        registerFragment = PasoCRegister()


        //++++++++++++++++++++++++++++++++++++++Retrofit
       // getAllRestaurants()
       // initRecyclerView()
        //++++++++++++++++++++++++++++++++++++++Retrofit

    }



    override fun onStart() {
        super.onStart()
        // el signo de ? sirve para indicar que puede ser nulable ya que el usuario puede ser nulo
        val user: FirebaseUser? = autenticacion.currentUser
        if (user == null){
            //manda a login
            supportFragmentManager.beginTransaction().add(R.id.fragmentContainerView,loginFragment).commit()
        }else{
            //avanzar a la pantalla principal
            supportFragmentManager.beginTransaction().add(R.id.fragmentContainerView, principalFragment)
                .commit()
        }
    }
    fun verificar(view: View) {
        PasoALogin()
    }


}