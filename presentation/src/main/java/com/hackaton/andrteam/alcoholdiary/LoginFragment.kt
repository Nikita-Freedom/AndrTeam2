package com.hackaton.andrteam.alcoholdiary

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.hackaton.andrteam.alcoholdiary.view.main.MainActivity
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onStart() {
        super.onStart()

        textViewRegister.setOnClickListener{
            (activity as MainActivity).navController.navigate(R.id.action_loginFragment_to_registerFragment)
        }

        buttonInput.setOnClickListener {
            val name = editTextLoginInput.text.toString().trim()
            val password: String = editTextPasswordInput.getText().toString().trim()
        }
    }
}