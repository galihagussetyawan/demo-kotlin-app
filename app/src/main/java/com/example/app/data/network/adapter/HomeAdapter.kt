package com.example.app.data.network.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.app.databinding.PostItemBinding
import com.example.app.model.Post
import com.google.android.material.snackbar.Snackbar

class HomeAdapter: RecyclerView.Adapter<HomeAdapter.ViewHolder>() {

    val dataList: List<Post> = listOf<Post>(
        Post(1, 1, "asdafa", "body"),
        Post(1, 1, "asdafa", "body"),
        Post(1, 1, "asdafa", "body"),
        Post(1, 1, "asdafa", "body"),
        Post(1, 1, "asdafa", "body"),
        Post(1, 1, "asdafa", "body"),
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: PostItemBinding = PostItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            binding.title.text = dataList?.get(position)?.title + position.toString()
            binding.title.setOnClickListener(View.OnClickListener {
                Toast.makeText(it.context, "Your position is ${position}", Toast.LENGTH_SHORT).show()
                Snackbar.make(holder.itemView, "asdasd", Snackbar.LENGTH_SHORT).show()
            })
        }
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    inner class ViewHolder(val binding: PostItemBinding) : RecyclerView.ViewHolder(binding.root)
}