package com.example.apprestaurantesv1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.apprestaurantesv1.databinding.FragmentPasoCRegisterBinding
import com.google.firebase.auth.FirebaseAuth

class PasoCRegister : Fragment() {
    private lateinit var binding: FragmentPasoCRegisterBinding
    lateinit var autenticacion: FirebaseAuth
    lateinit var loginFragment: PasoALogin
    lateinit var principalFragment: PasoBPrincipal

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPasoCRegisterBinding.inflate(inflater, container, false)
        autenticacion = FirebaseAuth.getInstance()
        principalFragment = PasoBPrincipal()
        loginFragment = PasoALogin()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnAceptarRegister.setOnClickListener {
            val correo: String = binding.etEmailRegister.text.toString()
            val password: String = binding.etPswRegister.text.toString()
            autenticacion.createUserWithEmailAndPassword(correo, password).addOnCompleteListener {
                if (it.isSuccessful) {
                    //avanzar a la pantalla principal
                    activity?.supportFragmentManager?.beginTransaction()
                        ?.replace(R.id.fragmentContainerView,principalFragment)
                        ?.commit()

                } else {
                    //mostrar resultado de error
                    Toast.makeText(requireContext(),"Algo salio mal", Toast.LENGTH_LONG).show()
                }
            }
        }
        binding.btnCancelarRegister.setOnClickListener {
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.fragmentContainerView,loginFragment)
                ?.commit()
        }
    }



}