package com.hackaton.andrteam.alcoholdiary

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.hackaton.andrteam.alcoholdiary.view.main.MainActivity
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.android.synthetic.main.fragment_login.buttonInput
import kotlinx.android.synthetic.main.fragment_login.textViewRegister
import kotlinx.android.synthetic.main.fragment_register.*

class RegisterFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_register, container, false)
    }

    override fun onStart() {
        super.onStart()

        textViewRegister.setOnClickListener(
            Navigation.createNavigateOnClickListener(
                R.id.loginFragment,
                null
            )
        )

        buttonInput.setOnClickListener {
            val name = editTextLogin.text.toString().trim()
            val password: String = editTextPassword.text.toString().trim()

            (activity as MainActivity).navController.navigate(R.id.action_registerFragment_to_questionnaireFragment2)
        }
    }
}