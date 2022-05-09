package com.example.apprestaurantesv1

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.apprestaurantesv1.databinding.ActivityMainBinding
import com.example.apprestaurantesv1.databinding.FragmentPasoCRegisterBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import java.security.Principal


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var loginFragment: PasoALogin
    private lateinit var principalFragment: PasoBPrincipal
    private lateinit var registerFragment: PasoCRegister
    //Variable para autenticar
    lateinit var autenticacion: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        autenticacion= FirebaseAuth.getInstance()
        loginFragment = PasoALogin()
        principalFragment = PasoBPrincipal()
        registerFragment = PasoCRegister()
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