package com.example.githubuser

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.githubuser.databinding.FragmentSignInBinding

class SignIn : Fragment() {
    private lateinit var binding: FragmentSignInBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSignInBinding.inflate(inflater, container, false)

        binding.btnSignIn.setOnClickListener {
            val username = binding.textField.editText?.text.toString()
            var action = SignInDirections.actionSignInToNavgraphHome()
            Navigation.findNavController(it).navigate(action)
        }
        return binding.root
    }

}