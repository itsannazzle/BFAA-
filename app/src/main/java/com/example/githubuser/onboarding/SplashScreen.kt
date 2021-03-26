package com.example.githubuser.onboarding

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.os.HandlerThread
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.githubuser.R
import com.example.githubuser.databinding.FragmentSplashScreenBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class SplashScreen : Fragment() {
    private lateinit var binding: FragmentSplashScreenBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSplashScreenBinding.inflate(inflater, container, false)
        /*Handler(Looper.getMainLooper()).postDelayed({
            view?.let { Navigation.findNavController(it).navigate(R.id.action_splashScreen_to_landingScreen) }
        }, 3000)*/
        lifecycleScope.launch {
            for (i in 0 until 100){
                delay(300)
                val precentage = i * 10
                withContext(Dispatchers.Main){
                    if (precentage == 100){
                        findNavController().navigate(R.id.action_splashScreen_to_landingScreen)
                    } else {

                    }
                }
            }
        }

        return binding.root
    }
    private fun onBoardingFinish() : Boolean{
        val sharedPreferences = requireActivity().getSharedPreferences("onboarding", Context.MODE_PRIVATE)
        return sharedPreferences.getBoolean("Finished",false)
    }
}