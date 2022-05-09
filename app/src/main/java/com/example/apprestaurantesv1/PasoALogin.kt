package com.example.apprestaurantesv1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.apprestaurantesv1.databinding.FragmentPasoALoginBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase
// FRAGMENT que contiene el login la pagina principal (PASO 1)
class PasoALogin : Fragment(){
    private lateinit var binding: FragmentPasoALoginBinding
    lateinit var autenticacion: FirebaseAuth
    lateinit var principalFragment: PasoBPrincipal
    lateinit var registerFragment: PasoCRegister

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPasoALoginBinding.inflate(inflater,container,false)
        autenticacion = FirebaseAuth.getInstance()
        principalFragment = PasoBPrincipal()
        registerFragment = PasoCRegister()
        return binding.root
       // return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnLogin.setOnClickListener{
            val correo: String = binding.etUser.text.toString()
            val password: String = binding.etPwd.text.toString()
            autenticacion.signInWithEmailAndPassword(correo,password).addOnCompleteListener{
                if(it.isSuccessful){
                    //ir a la pantalla siguiente
                    activity?.supportFragmentManager?.beginTransaction()
                        ?.replace(R.id.fragmentContainerView,principalFragment)
                        ?.commit()
                }else{
                    // mostrar error
                    Toast.makeText(requireContext(),"Algo salio mal", Toast.LENGTH_LONG).show()
                }

            }
        }
        //le pones oncliclistener al boton registrarse
        binding.btnRegistrar.setOnClickListener {
            //sirve para remplazar el fragment en el contenedor
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.fragmentContainerView, registerFragment)
                ?.commit()
        }

    }

}