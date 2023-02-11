package com.example.app.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.app.R
import com.example.app.`view-model`.HomeViewModel
import com.example.app.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private val homeViewModel: HomeViewModel by activityViewModels<HomeViewModel>()
    lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)

        binding.buttonHome.setOnClickListener(View.OnClickListener {
            homeViewModel.toggle()
        })

        binding.registerButton.setOnClickListener(View.OnClickListener {
            navController.navigate(R.id.navigation_register)
        })

        homeViewModel?.getIsLogin()?.observe(viewLifecycleOwner, Observer {
            binding.homeFragmentText.text = it.toString()
        })
    }
}