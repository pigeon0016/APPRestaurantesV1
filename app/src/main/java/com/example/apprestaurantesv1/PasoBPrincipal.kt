package com.example.apprestaurantesv1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.apprestaurantesv1.databinding.FragmentPasoBPrincipalBinding
import com.google.firebase.auth.FirebaseAuth
// FRAGMENT que contiene la paguna prncialp el home de la app
class PasoBPrincipal : Fragment() {
     private lateinit var  binding: FragmentPasoBPrincipalBinding
     lateinit var autenticacion: FirebaseAuth
     lateinit var loginFragment: PasoALogin

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
}