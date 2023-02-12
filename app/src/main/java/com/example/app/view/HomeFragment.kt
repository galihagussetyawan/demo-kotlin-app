package com.example.app.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.app.R
import com.example.app.`view-model`.HomeViewModel
import com.example.app.data.network.Retrofit
import com.example.app.data.network.repository.PostRepository
import com.example.app.data.network.service.PostService
import com.example.app.databinding.FragmentHomeBinding
import com.example.app.model.Post
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private val homeViewModel: HomeViewModel by activityViewModels<HomeViewModel>()
    lateinit var navController: NavController
    private var postRepository: PostRepository? = null

    init {
        postRepository = PostRepository()
    }

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

        binding.layoutAppBar.searchBar.setOnClickListener(View.OnClickListener {
            binding.layoutAppBar.searchView.show()
        })

        homeViewModel?.getIsLogin()?.observe(viewLifecycleOwner, Observer {
            binding.homeFragmentText.text = it.toString()
        })

        getData()
    }

    fun getData() {
        var data: LiveData<List<Post>>? = null

        data = postRepository?.fetchAllPosts()
        data?.observe(viewLifecycleOwner, Observer {
            val postList: List<Post> = it
            binding.homeFragmentText.text = postList?.get(1)?.title
        })
    }
}