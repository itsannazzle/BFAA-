package com.example.githubuser

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.githubuser.databinding.FragmentLandingScreenBinding

class LandingScreen : Fragment() {
    private lateinit var binding: FragmentLandingScreenBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = FragmentLandingScreenBinding.inflate(inflater, container, false)

        binding.btnSignIn.setOnClickListener { view ->
           Navigation.findNavController(view).navigate(R.id.action_landingScreen_to_signIn)
        }
        binding.btnSignUp.setOnClickListener {

        }

        return binding.root
    }


}